DROP TRIGGER TRIGGER_TECNICOS;
DROP TRIGGER MAX_NUM_JUGADORES;
DROP TRIGGER TRIGGER_CALENDARIOS;
DROP TRIGGER TRIGGER_CALENDARIO_CERRADO;
DROP TABLE PERFILES;
DROP TABLE JUGADORES;
DROP TABLE TECNICOS;
DROP TABLE PARTIDOS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;
DROP TABLE JEFES CASCADE CONSTRAINTS;
DROP TABLE JORNADAS CASCADE CONSTRAINTS;
DROP TABLE CALENDARIOS CASCADE CONSTRAINTS;


---- Creación Tablas


CREATE TABLE JEFES (
    ID_JEFE NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                        START WITH 1
                                        INCREMENT BY 1
                                        MAXVALUE 999
                                        NOCYCLE
                                     ) PRIMARY KEY,
    DNI VARCHAR2(9) UNIQUE NOT NULL,
    NOMBRE VARCHAR2(25) NOT NULL,
    APELLIDOS VARCHAR2(30) NOT NULL,
    NICKNAME VARCHAR2(30) UNIQUE NULL,
    EMAIL VARCHAR2(25) UNIQUE NOT NULL
);


CREATE TABLE EQUIPOS (
    ID_EQUIPO NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                        START WITH 1
                                        INCREMENT BY 1
                                        MAXVALUE 999
                                        NOCYCLE
                                     ) PRIMARY KEY,
    NOMBRE VARCHAR2(25) UNIQUE NOT NULL,
    --ESCUDO
    ID_JEFE NUMBER(3) UNIQUE,
    CONSTRAINT EQU_JEFE_FK FOREIGN KEY (ID_JEFE) REFERENCES JEFES(ID_JEFE) 
    ON DELETE SET NULL
);

CREATE TABLE CALENDARIOS (
    ID_CALENDARIO NUMBER(3) GENERATED ALWAYS AS IDENTITY(
                                                        START WITH 1
                                                        INCREMENT BY 1
                                                        MAXVALUE 999
                                                        NOCYCLE
                                                        ) PRIMARY KEY,
    FECHA_CIERRE DATE NOT NULL,
    FECHA_EXPIRACION DATE NOT NULL,
    DESCRIPCION VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE JUGADORES (
    ID_JUGADORES NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                 START WITH 1
                                                 INCREMENT BY 1
                                                 MAXVALUE 999
                                                 NOCYCLE
                                                 ) PRIMARY KEY,
   DNI VARCHAR2(9) UNIQUE NOT NULL,
   NOMBRE VARCHAR2(25) NOT NULL,
   APELLIDOS VARCHAR2(30) NOT NULL,
   NICKNAME VARCHAR(30) UNIQUE NULL,
   ROL VARCHAR2(35) NOT NULL,
   SUELDO NUMBER(6) NOT NULL,
   DORSAL NUMBER(2) NOT NULL,
   ID_EQUIPO NUMBER(3),
   CONSTRAINT JUG_ROL_CK CHECK(UPPER(ROL) IN ('TOP','JUNGLA','MID','ADC','SUPPORT','SUPLENTE')),
   CONSTRAINT JUG_SUELDO_CK CHECK(SUELDO>950),
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
    DNI VARCHAR2(9) UNIQUE NOT NULL,
    NOMBRE VARCHAR2(25) NOT NULL,
    APELLIDOS VARCHAR2(30) NOT NULL,
    NICKNAME VARCHAR(30) NULL,
    SUELDO NUMBER(6) NOT NULL,
    TIPO VARCHAR2(30) NOT NULL,
    ID_EQUIPO NUMBER(3),
    CONSTRAINT TEC_TIPO_CK CHECK (UPPER(TIPO) IN ('PRINCIPAL','ASISTENTE')),
    CONSTRAINT TEC_EQU_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS
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
    ID_CALENDARIO NUMBER(3) NOT NULL,
    CONSTRAINT JOR_CAL_FK FOREIGN KEY (ID_CALENDARIO)
    REFERENCES CALENDARIOS (ID_CALENDARIO) ON DELETE CASCADE
);

CREATE TABLE PARTIDOS (
    ID_PARTIDO NUMBER(3) GENERATED ALWAYS AS IDENTITY (
                                                        START WITH 1
                                                        INCREMENT BY 1
                                                        MAXVALUE 999
                                                        NOCYCLE
                                                      ) PRIMARY KEY,
    HORA TIMESTAMP NOT NULL,
    PARTIDAS_GANADAS_LOCAL NUMBER(3),
    PARTIDAS_GANADAS_VISITANTE NUMBER(3),
    ID_LOCAL NUMBER(3),
    ID_VISITANTE NUMBER(3),
    ID_JORNADA NUMBER(3),
    ID_EQUIPO_GANADOR NUMBER(3),
    CONSTRAINT PAR_JOR_FK FOREIGN KEY (ID_JORNADA) REFERENCES JORNADAS
    (ID_JORNADA) ON DELETE CASCADE,
    CONSTRAINT PAR_EQU_FK FOREIGN KEY (ID_EQUIPO_GANADOR) REFERENCES
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
    TIPO VARCHAR(5),
    CONSTRAINT PER_TIP_CK CHECK (TIPO IN ('ADMIN','USU'))
);


--Creación Triggers


CREATE OR REPLACE TRIGGER TRIGGER_TECNICOS --Para controlar que ningún equipo pueda tener más de dos técnicos y que solo se pueda añadir un técnico asistente en los equipos que ya tengan uno principal
BEFORE INSERT ON TECNICOS
FOR EACH ROW
DECLARE
    V_TECNICOS NUMBER(1):=0;

    CURSOR NUMERO_TECNICOS IS
    SELECT NVL(COUNT(*),0)
    FROM TECNICOS
    GROUP BY ID_EQUIPO
    HAVING ID_EQUIPO=:NEW.ID_EQUIPO;
BEGIN
    OPEN NUMERO_TECNICOS;
    FETCH NUMERO_TECNICOS INTO V_TECNICOS;
    
    CASE
        WHEN (V_TECNICOS=0 AND UPPER(:NEW.TIPO)='ASISTENTE') THEN RAISE_APPLICATION_ERROR(-20002,'No se puede añadir un técnico asistente a un equipo que no tiene un técnico principal');
        WHEN (V_TECNICOS=1 AND UPPER(:NEW.TIPO)='PRINCIPAL') THEN RAISE_APPLICATION_ERROR(-20002,'Este equipo ya tiene un técnico principal');
        WHEN (V_TECNICOS=2) THEN RAISE_APPLICATION_ERROR(-20002,'Este equipo ya tiene un técnico principal y otro asistente');
        ELSE NULL;
    END CASE;
END TRIGGER_TECNICOS;


CREATE OR REPLACE TRIGGER MAX_NUM_JUGADORES --Trigger para controlar que en ningún equipo se puedan agregar más de 6 jugadores
BEFORE INSERT ON JUGADORES
FOR EACH ROW
DECLARE
    V_NUM_JUGADORES NUMBER(1);
    CURSOR NUM_JUGADORES IS
    SELECT COUNT(*)
    FROM JUGADORES
    GROUP BY ID_EQUIPO
    HAVING ID_EQUIPO=:NEW.ID_EQUIPO;
BEGIN
    OPEN NUM_JUGADORES;
    FETCH NUM_JUGADORES INTO V_NUM_JUGADORES;
    CLOSE NUM_JUGADORES;
    IF(V_NUM_JUGADORES=6) THEN
        RAISE_APPLICATION_ERROR(-20000,'El equipo ya tiene 6 jugadores');
    END IF;
END MAX_NUM_JUGADORES;



CREATE OR REPLACE TRIGGER TRIGGER_CALENDARIOS --Trigger para controlar que el calendario no se genere si hay algún equipo que tenga menos de 2 jugadores
BEFORE INSERT ON CALENDARIOS
FOR EACH ROW
DECLARE
    CURSOR MICURSOR IS
    SELECT COUNT(*)
    FROM JUGADORES
    GROUP BY ID_EQUIPO;
    V_NUMERO NUMBER(2);
BEGIN
    OPEN MICURSOR;
    FETCH MICURSOR INTO V_NUMERO;
    WHILE(MICURSOR%FOUND) LOOP
        IF(V_NUMERO<2) THEN
            CLOSE MICURSOR;
            RAISE_APPLICATION_ERROR(-20005,'El calendario no puede generarse si hay equipos con menos de 2 jugadores');
        END IF;
        FETCH MICURSOR INTO V_NUMERO;
    END LOOP;
    CLOSE MICURSOR;
END TRIGGER_CALENDARIOS;


CREATE OR REPLACE TRIGGER TRIGGER_CALENDARIO_CERRADO
BEFORE INSERT OR UPDATE ON JUGADORES
FOR EACH ROW
DECLARE
    V_FECHA_CIERRE DATE;
    V_FECHA_EXPIRACION DATE;
    CURSOR C_FECHAS IS
    SELECT FECHA_CIERRE, Fecha_expiracion
    FROM CALENDARIOS
    WHERE EXTRACT(YEAR FROM FECHA_CIERRE)=EXTRACT(YEAR FROM SYSDATE);
BEGIN
    OPEN C_FECHAS;
    FETCH C_FECHAS INTO V_FECHA_CIERRE, V_FECHA_EXPIRACION;
    IF SYSDATE>V_FECHA_CIERRE and SYSDATE<V_FECHA_EXPIRACION THEN
        CLOSE C_FECHAS;
        RAISE_APPLICATION_ERROR(-20010,'El calendario está cerrado');
    END IF;
    CLOSE C_FECHAS;
END TRIGGER_CALENDARIOS_CERRADO;

