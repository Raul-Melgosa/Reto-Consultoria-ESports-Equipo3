-- Primer ejemplo --- 
DROP TABLE TEMP_JORNADA_CLOB;

CREATE TABLE TEMP_JORNADA_CLOB
(DATOS CLOB);

DROP TYPE tipoClasificacion;
DROP TYPE equipolistTipo;
DROP TYPE tipoEquipo;



CREATE TYPE equipo AS OBJECT ("@Id_equipo" NUMBER(3),
                                    Puntos NUMBER(3));

CREATE TYPE equipolistTipo AS TABLE OF equipo;

CREATE TYPE tipoClasificacion AS OBJECT (listaEquipos equipolistTipo);

DECLARE
  contexto DBMS_XMLGEN.ctxHandle;
  resultado CLOB;
BEGIN
  contexto := DBMS_XMLGEN.newContext(
               'SELECT tipoClasificacion(cast(MULTISET
                                        (SELECT E.ID_EQUIPO,NVL(COUNT(P.ID_EQUIPO_GANADOR)*3,0) PUNTOS
                                        FROM EQUIPOS E, PARTIDOS P
                                        WHERE ID_EQUIPO=ID_EQUIPO_GANADOR(+)
                                        GROUP BY ID_EQUIPO
                                        ORDER BY PUNTOS DESC)
                                    AS EQUIPOLISTTIPO)) AS Clasificacion,
                        FECHA
                FROM JORNADAS'
            );
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(contexto, 'documento');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(contexto, 'clasificacion');
  
  -- Get the result
  resultado := DBMS_XMLGEN.getXML(contexto);
  INSERT INTO TEMP_JORNADA_CLOB VALUES(resultado);
  
  --Close context
  DBMS_XMLGEN.closeContext(contexto);
END;
