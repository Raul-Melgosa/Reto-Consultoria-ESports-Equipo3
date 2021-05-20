-- Primer ejemplo --- 
DROP TABLE TEMP_JORNADA_CLOB;

CREATE TABLE TEMP_JORNADA_CLOB
(DATOS CLOB);

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
               'SELECT E.ID_EQUIPO,NVL(COUNT(P.ID_EQUIPO_GANADOR)*3,0) PUNTOS
                FROM EQUIPOS E, PARTIDOS P
                WHERE ID_EQUIPO=ID_EQUIPO_GANADOR(+)
                GROUP BY ID_EQUIPO
                ORDER BY PUNTOS DESC'
            );
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificacion');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'equipo');
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO TEMP_JORNADA_CLOB VALUES(result);
  
  --Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;
