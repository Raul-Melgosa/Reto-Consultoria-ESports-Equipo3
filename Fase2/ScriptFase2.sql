DROP TABLE JUGADORES;
DROP TABLE TECNICOS;
DROP TABLE PARTIDOS;
DROP TABLE EQUIPOS;
DROP TABLE JEFES;
DROP TABLE JORNADAS;
DROP TABLE CALENDARIO;
DROP TABLE PERFILES;


CREATE TABLE JEFES (
    ID_JEFE NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                        START WITH 1
                                        INCREMENT BY 1
                                        MAXVALUE 999
                                        NOCYCLE
                                     ) PRIMARY KEY,
    DNI VARCHAR2(9) NOT NULL,
    NOMBRE VARCHAR2(25) NOT NULL,
    APELLIDOS VARCHAR2(30) NOT NULL,
    NICKNAME VARCHAR2(30) NULL,
    EMAIL VARCHAR2(25) NOT NULL
);


CREATE TABLE EQUIPOS (
    ID_EQUIPO NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                        START WITH 1
                                        INCREMENT BY 1
                                        MAXVALUE 999
                                        NOCYCLE
                                     ) PRIMARY KEY,
    NOMBRE VARCHAR2(25) NOT NULL,
    --ESCUDO
    ID_JEFE NUMBER(3),
    CONSTRAINT EQU_JEFE_FK FOREIGN KEY (ID_JEFE) REFERENCES JEFES(ID_JEFE) 
    ON DELETE SET NULL
);

CREATE TABLE CALENDARIO (
    ID_CALENDARIO NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                                        START WITH 1
                                                        INCREMENT BY 1
                                                        MAXVALUE 999
                                                        NOCYCLE
                                                        ) PRIMARY KEY,
    FECHA_CIERRE DATE NOT NULL,
    DESCRIPCION VARCHAR2(50) NOT NULL
);

CREATE TABLE JUGADORES (
    ID_JUGADORES NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                 START WITH 1
                                                 INCREMENT BY 1
                                                 MAXVALUE 999
                                                 NOCYCLE
                                                 ) PRIMARY KEY,
   DNI VARCHAR2(9) NOT NULL,
   NOMBRE VARCHAR2(25) NOT NULL,
   NICKNAME VARCHAR(30) NULL,
   ROL VARCHAR2(35) NOT NULL,
   SUELDO NUMBER(6) NOT NULL,
   DORSAL NUMBER(2) NOT NULL,
   ID_EQUIPO NUMBER(3),
   CONSTRAINT JUG_EQU_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS (ID_EQUIPO) 
   ON DELETE SET NULL
);

CREATE TABLE TECNICOS (
    ID_TECNICO NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                       START WITH 1
                                                       INCREMENT BY 1
                                                       MAXVALUE 999
                                                       NOCYCLE
                                                      ) PRIMARY KEY,
    DNI VARCHAR2(9) NOT NULL,
    NOMBRE VARCHAR2(25) NOT NULL,
    NICKNAME VARCHAR(30) NULL,
    TIPO VARCHAR2(30) NOT NULL,
    ID_EQUIPO NUMBER(3),
    CONSTRAINT TECNICOS TEC_TIPO_CK CHECK (TIPO IN ('PRINCIPAL','ASISTENTE'))
    CONSTRAINT TECNICOS TEC_EQU_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS
    (ID_EQUIPO) ON DELETE SET NULL
);

CREATE TABLE JORNADAS (
    ID_JORNADA NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                        START WITH 1
                                                        INCREMENT BY 1
                                                        MAXVALUE 999
                                                        NOCYCLE
                                                      ) PRIMARY KEY,
    FECHA DATE NOT NULL,
    ID_CALENDARIO NUMBER(3),
 CONSTRAINT JORNADA JOR_CAL_FK FOREIGN KEY (ID_CALENDARIO)
 REFERENCES CALENDARIO (ID_CALENDARIO)
);

CREATE TABLE PARTIDOS (
    ID_PARTIDO NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                        START WITH 1
                                                        INCREMENT BY 1
                                                        MAXVALUE 999
                                                        NOCYCLE
                                                      ) PRIMARY KEY,
    HORA TIME NOT NULL,
    PARTIDAS_GANADAS_LOCAL NUMBER(3),
    PARTIDAS_GANADAS_VISITANTE NUMBER(3),
    ID_JORNADA NUMBER(3),
    ID_EQUIPO_GANADOR NUMBER(3),
    CONSTRAINT PARTIDOS PAR_JOR_FK FOREIGN KEY (ID_JORNADA) REFERENCES JORNADAS
    (ID_JORNADA) ON DELETE SET NULL,
    CONSTRAINT PARTIDOS PAR_EQU_FK FOREIGN KEY (ID_EQUIPO_GANADOR) REFERENCES
    EQUIPOS (ID_EQUIPO) ON DELETE SET NULL
);

CREATE TABLE PERFILES (
    ID_PERFIL NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                                     START WITH 1
                                                     INCREMENT BY 1
                                                     MAXVALUE 999
                                                     NOCYCLE
                                                    ) PRIMARY KEY,
    NOMBRE_USUARIO VARCHAR2(25) NOT NULL,
    CONTRASENNA VARCHAR2(25) NOT NULL,
    EMAIL VARCHAR2(25),
    TIPO VARCHAR(25),
    CONSTRAINT PERFILES PER_TIP_CK CHECK (TIPO IN ('ADMIN','USU'))
);
