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
('11111111l','Aaaa','Aaaa','Aaaa',30000,(SELECT ID_EQUIPO FROM EQUIPOS 
WHERE UPPER(NOMBRE)='G2 ESPORTS'),'PRINCIPAL');

//

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

//
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

//
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
//
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO)
VALUES('AlaitzCandela','alaitz200@gmail.com','12345Abcd','ADMIN');
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('VelarSnake','oierajo@gmail.com','12345Abcd','ADMIN');
INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('RaulMelgosa','raulmelco@gmail.com','12345Abcd','ADMIN');

INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) 
VALUES('Usuario','usuario@gmail.com','usuario','USU');
//


ROLLBACK;
