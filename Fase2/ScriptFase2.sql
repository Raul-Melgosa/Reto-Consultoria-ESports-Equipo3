                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               DROP TABLE PERFILES;
DROP TABLE JUGADORES;
DROP TABLE TECNICOS;
DROP TABLE PARTIDOS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;
DROP TABLE JEFES CASCADE CONSTRAINTS;
DROP TABLE JORNADAS CASCADE CONSTRAINTS;
DROP TABLE CALENDARIO CASCADE CONSTRAINTS;
DROP TABLE TEMP_JUGADORES;

CREATE TABLE TEMP_JUGADORES(
    ID_EQUIPO NUMBER(3),
    SUELDO NUMBER(10)
);

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
   DNI VARCHAR2(9) UNIQUE NOT NULL,
   NOMBRE VARCHAR2(25) NOT NULL,
   APELLIDOS VARCHAR2(30) NOT NULL,
   NICKNAME VARCHAR(30) UNIQUE NULL,
   ROL VARCHAR2(35) NOT NULL,
   SUELDO NUMBER(6) NOT NULL,
   DORSAL NUMBER(2) NOT NULL,
   ID_EQUIPO NUMBER(3),
   CONSTRAINT JUG_ROL_CK CHECK(UPPER(ROL) IN ('TOP','JUNGLA','MID','ADC','SUPPORT','SUPLENTE')),
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
    REFERENCES CALENDARIO (ID_CALENDARIO) ON DELETE CASCADE
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
    ID_JORNADA NUMBER(3),
    ID_EQUIPO_GANADOR NUMBER(3),
    CONSTRAINT PAR_JOR_FK FOREIGN KEY (ID_JORNADA) REFERENCES JORNADAS
    (ID_JORNADA) ON DELETE SET NULL,
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

CREATE OR REPLACE TRIGGER TRIGGER_TECNICOS
BEFORE INSERT ON TECNICOS
FOR EACH ROW
DECLARE
    V_TECNICOS NUMBER(1):=0;
    V_TECNICOS_2 NUMBER(1):=0;

    CURSOR NUMERO_PRINCIPALES IS
    SELECT NVL(COUNT(*),0) FROM TECNICOS
    GROUP BY ID_EQUIPO,TIPO
    HAVING ID_EQUIPO=:NEW.ID_EQUIPO
    AND UPPER(TIPO)='PRINCIPAL';
    
    CURSOR NUMERO_ASISTENTES IS
    SELECT NVL(COUNT(*),0) FROM TECNICOS
    GROUP BY ID_EQUIPO,TIPO
    HAVING ID_EQUIPO=:NEW.ID_EQUIPO
    AND UPPER(TIPO)='ASISTENTE';
BEGIN
    IF(UPPER(:NEW.TIPO)='PRINCIPAL') THEN
        OPEN NUMERO_PRINCIPALES;
        
        FETCH NUMERO_PRINCIPALES INTO V_TECNICOS;
        IF(V_TECNICOS = 1) THEN
            RAISE_APPLICATION_ERROR(-20002,'Este equipo ya tiene un t�cnico principal');
        END IF;
        CLOSE NUMERO_PRINCIPALES;
    ELSE
        OPEN NUMERO_ASISTENTES;
        FETCH NUMERO_ASISTENTES INTO V_TECNICOS_2;
        IF(V_TECNICOS_2 = 1) THEN
            RAISE_APPLICATION_ERROR(-20003,'Este equipo ya tiene un t�cnico asistente');
        END IF;
    END IF;
END;


CREATE OR REPLACE TRIGGER MAX_NUM_JUGADORES
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
END;


CREATE OR REPLACE TRIGGER JUG_MAX_SUELDO
AFTER INSERT OR UPDATE OF SUELDO ON JUGADORES
FOR EACH ROW
BEGIN
    INSERT INTO TEMP_JUGADORES VALUES(:NEW.ID_EQUIPO,:NEW.SUELDO);
END;

CREATE OR REPLACE TRIGGER JUG_MAX_SUELDO_1
AFTER INSERT OR UPDATE OF SUELDO ON JUGADORES
DECLARE
    V_SUELDOS NUMBER(10);

    CURSOR C_SUELDOS IS
    SELECT NVL(SUM(J.SUELDO)*14,0)+NVL(SUM(T.SUELDO)*14,0) SUMA_SUELDOS
    FROM TEMP_JUGADORES J,TECNICOS T
    WHERE J.ID_EQUIPO=T.ID_EQUIPO
    GROUP BY J.ID_EQUIPO;
BEGIN
    OPEN C_SUELDOS;
    FETCH C_SUELDOS INTO V_SUELDOS;
    
    IF(V_SUELDOS>200000) THEN
        RAISE_APPLICATION_ERROR(-20004,'El equipo superar�a el l�mite salarial anual');
    END IF;
    CLOSE C_SUELDOS;
END;














































INSERT INTO JEFES(DNI,NOMBRE,APELLIDOS,NICKNAME,EMAIL) 
VALUES('44646468V','Carlos','Rodriguez','Ocelote','ocelote@gmail.com');

INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES('G2 ESPORTS',
(SELECT ID_JEFE FROM JEFES WHERE UPPER(NICKNAME)='OCELOTE'));

INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('56466546D','Martin','Hansen','Wunder','TOP',1,15000,
(SELECT ID_EQUIPO  FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('14457445S','Marcin','Jankowski','Jankos','JUNGLA',2,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('45666524F','Rasmus','Winther','Caps','MID',3,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('47234698G','Carl Martin','Erik Larsson','Rekkles','ADC',4,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('41236987L','Mihael','Mehle','Mikyx','SUPPORT',5,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('52042072P','Kristoffer','Albao','P1noy','SUPLENTE',6,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));

INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('04242720D','Elm','Cherto','Elmillor','JUNGLA',7,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='G2 ESPORTS'));

INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) VALUES 
('57442417K','Fabian','Lohmann','GrabbZ',30000,(SELECT ID_EQUIPO FROM EQUIPOS 
WHERE UPPER(NOMBRE)='G2 ESPORTS'),'PRINCIPAL');
INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) VALUES 
('86723122A','Aaaa','Aaaa','Aaaa',30000,(SELECT ID_EQUIPO FROM EQUIPOS 
WHERE UPPER(NOMBRE)='G2 ESPORTS'),'ASISTENTE');
INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) VALUES 
('11111111f','Bbbb','Bbbb','Bbbb',30000,(SELECT ID_EQUIPO FROM EQUIPOS 
WHERE UPPER(NOMBRE)='G2 ESPORTS'),'ASISTENTE');

--//

INSERT INTO JEFES(DNI,NOMBRE,APELLIDOS,NICKNAME,EMAIL) 
VALUES('55444245R','Ibai','Llanos','Ibai','IbaiLlanos@gmail.com');

INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES('Ibaisitos',
(SELECT ID_JEFE FROM JEFES WHERE UPPER(NICKNAME)='IBAI'));

INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('42245242Z','Jorge','Casanovas','Werlyb','TOP',1,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('13579468X','Sergio','Garcia','Knekro','JUNGLA',2,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('12384889L','Antonio','Pino','Reven_Manopocha','MID',3,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('46986469K','Ernesto','Folch','Barbeq','ADC',4,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('469786469L','Ander','Cortes','Ander','SUPPORT',5,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('459687567O','Cristina','Lopez','Cristinini','SUPLENTE',6,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'));

INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) VALUES 
('45697876U','Juan Alberto','Garcia','IlloJuan',1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'),'PRINCIPAL');

--//
INSERT INTO JEFES(DNI,NOMBRE,APELLIDOS,NICKNAME,EMAIL)
VALUES('45968456Q','Alaitz','Candela','Alaitzu','alaitz.candela@gmail.com');

INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES('Vel�kcoc',
(SELECT ID_JEFE FROM JEFES WHERE UPPER(NICKNAME)='Alaitzu'));

INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('58011619F','Oier','Velar','VelarSnake','TOP',1,1500,(SELECT ID_EQUIPO
FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('72854024Y','Rafael','Blazquez','Leorafardo','JUNGLA',2,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('71350682J','Raul','Melgosa','Raumeco','MID',3,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('53982287E','Sergio','Olabuenaga','Sergi225','ADC',4,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('71349935W','Guillermo','Mediero','Madafaka3030','SUPPORT',5,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('65978646P','Juanjo','Narvaez','El_navajas69','SUPLENTE',6,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='VEL�KCOC'));

INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) 
VALUES ('53983064V','Alvaro','Mu�oz','Ironfix',1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='IBAISITOS'),'PRINCIPAL');

--//
INSERT INTO JEFES(DNI,NOMBRE,APELLIDOS,NICKNAME,EMAIL) VALUES
('99999999S','Alvar','Martin','Araneae','AlvarMartin@gmail.com');

INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES('MAD Lions',
(SELECT ID_JEFE FROM JEFES WHERE UPPER(NICKNAME)='Araneae'));

INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('45697647L','T�kek','Irfan Berk','Armut','TOP',1,1500,
(SELECT ID_EQUIPOFROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('12369875J','Javier','Prades','Elyoya','JUNGLA',2,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('75984631O','Marek','Brazda','Humanoid','MID',3,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('56987413I','Matyas','Orsag','Carzzy','ADC',4,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) 
VALUES ('59874631H','Norman','Kaiser','Kaiser','SUPPORT',5,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));
INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO)
VALUES ('75963584G','Juan','Lopes','JuanLo','SUPLENTE',6,1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'));

INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) 
VALUES ('75984631U','James','MacCormack','Mac',1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'),'PRINCIPAL');
INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) 
VALUES ('75896412G','Cristophe','van Oudheusden','Kaas',1500,
(SELECT ID_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE)='MAD Lions'),'ASISTENTE');
--//
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO)
VALUES('AlaitzCandela','alaitz200@gmail.com','12345Abcd','ADMIN');
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('VelarSnake','oierajo@gmail.com','12345Abcd','ADMIN');
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('RaulMelgosa','raulmelco@gmail.com','12345Abcd','ADMIN');

INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('Usuario','usuario@gmail.com','usuario','USU');
--//
ROLLBACK;
ALTER TRIGGER MAX_NUM_JUGADORES DISABLE;