DROP TABLE EQUIPOS;
DROP TABLE JEFES;

CREATE TABLE JEFES (
    ID_JEFE NUMBER(3) GENERATED AS IDENTITY(
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
    ID_EQUIPO NUMBER(3) GENERATED AS IDENTITY(
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