CREATE TABLE TITULACION (CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, NOMBRE VARCHAR(52) NOT NULL, PRIMARY KEY (CODIGO))
CREATE TABLE ALUMNO (ID BIGINT NOT NULL, APELLIDO1 VARCHAR(52) NOT NULL, APELLIDO2 VARCHAR(52), CODIGO_POSTAL INTEGER, DNI VARCHAR(20) NOT NULL UNIQUE, DIRECCION VARCHAR(255), EMAIL_INSTITUCIONAL VARCHAR(52) NOT NULL, EMAIL_PERSONAL VARCHAR(52), LOCALIDAD VARCHAR(255), MOVIL INTEGER, NOMBRE VARCHAR(52) NOT NULL, PROVINCIA VARCHAR(55), TELEFONO INTEGER, PRIMARY KEY (ID))
CREATE TABLE CLASE (DIA VARCHAR(255) NOT NULL, HORA_INICIO VARCHAR(255) NOT NULL, HORA_FIN VARCHAR(255), ASIGNATURA_REFERENCIA INTEGER, GRUPOS_ID VARCHAR(255) NOT NULL, PRIMARY KEY (DIA, HORA_INICIO, GRUPOS_ID))
CREATE TABLE ASIGNATURAS (REFERENCIA INTEGER NOT NULL, DTYPE VARCHAR(31), CARACTER VARCHAR(255), CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, CURSO VARCHAR(255), DURACION VARCHAR(255), IDIOMAS_IMPARTICION VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, OFERTADA TINYINT(1) default 0 NOT NULL, UNIDAD_TEMPORAL VARCHAR(255), TITULACION_CODIGO INTEGER, PRIMARY KEY (REFERENCIA))
CREATE TABLE OPTATIVA (REFERENCIA INTEGER NOT NULL, MENCION VARCHAR(255), PLAZAS INTEGER NOT NULL, PRIMARY KEY (REFERENCIA))
CREATE TABLE CENTRO (ID VARCHAR(52) NOT NULL, DIRECCION VARCHAR(52) NOT NULL, NOMBRE VARCHAR(52) NOT NULL UNIQUE, TLF_CONSERJERIA INTEGER, PRIMARY KEY (ID))
CREATE TABLE ENCUESTA (FECHA_DE_ENVIO DATETIME NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (FECHA_DE_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE EXPEDIENTES (NUM_EXPEDIENTE BIGINT NOT NULL, ACTIVO TINYINT(1) default 0, CREDITOS_CF DOUBLE, CREDITOS_FB DOUBLE, CREDITOS_OB DOUBLE, CREDITOS_OP DOUBLE, CREDITOS_PE DOUBLE, CREDITOS_TF DOUBLE, CREDITOS_SUPERADOS DOUBLE, NOTA_MEDIA_PROVISIONAL DOUBLE, ALUMNO_ID BIGINT, TITULACION_CODIGO INTEGER, PRIMARY KEY (NUM_EXPEDIENTE))
CREATE TABLE MATRICULA (CURSO_ACADEMICO VARCHAR(255) NOT NULL, ESTADO VARCHAR(20) NOT NULL, FECHA_DE_MATRICULA DATETIME NOT NULL, NUEVO_INGRESO TINYINT(1) default 0, NUM_ARCHIVO INTEGER, TURNO_PREFERENTE VARCHAR(255), EXPEDIENTES_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE))
CREATE TABLE GRUPO (ID VARCHAR(255) NOT NULL, ASIGNABLE TINYINT(1) default 0, CURSO VARCHAR(20) NOT NULL UNIQUE, GRUPO_PREFERENTE VARCHAR(1), INGLES TINYINT(1) default 0 NOT NULL, LETRA VARCHAR(1) NOT NULL UNIQUE, PLAZAS DECIMAL(38) NOT NULL, TURNO_MA�ANA_TARDE VARCHAR(20) NOT NULL, VISIBLE TINYINT(1) default 0, grupoID VARCHAR(255), TITULACION_CODIGO INTEGER, PRIMARY KEY (ID))
CREATE TABLE GRUPOS_POR_ASIGNATURA (CURSO_ACADEMICO VARCHAR(52) NOT NULL, OFERTA TINYINT(1) default 0, ID_ID VARCHAR(255) NOT NULL, REFERENCIA_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, ID_ID, REFERENCIA_REFERENCIA))
CREATE TABLE ASIGNATURAS_MATRICULA (ASIGNATURA_REFERENCIA INTEGER NOT NULL, GRUPO_ID VARCHAR(255), EXPEDIENTES_NUM_EXPEDIENTE BIGINT NOT NULL, CURSO_ACADEMICO VARCHAR(255) NOT NULL, PRIMARY KEY (ASIGNATURA_REFERENCIA, EXPEDIENTES_NUM_EXPEDIENTE, CURSO_ACADEMICO))
CREATE TABLE jn_tit_cntr (tit_fk INTEGER NOT NULL, centro_fk VARCHAR(52) NOT NULL, PRIMARY KEY (tit_fk, centro_fk))
CREATE TABLE jn_tit_opt (titulaciones_CODIGO INTEGER NOT NULL, optativa_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (titulaciones_CODIGO, optativa_REFERENCIA))
CREATE TABLE jn_enc_grpXasi (FECHA_DE_ENVIO DATETIME NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE BIGINT NOT NULL, CURSO_ACADEMICO VARCHAR(52) NOT NULL, ID_ID VARCHAR(255) NOT NULL, REFERENCIA_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (FECHA_DE_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE, CURSO_ACADEMICO, ID_ID, REFERENCIA_REFERENCIA))
CREATE TABLE MATRICULA_ASIGNATURAS (CURSO_ACADEMICO VARCHAR(255) NOT NULL, EXPEDIENTES_NUM_EXPEDIENTE BIGINT NOT NULL, Listado_Asignaturas_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE, Listado_Asignaturas_REFERENCIA))
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GRUPOS_ID FOREIGN KEY (GRUPOS_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE ASIGNATURAS ADD CONSTRAINT FK_ASIGNATURAS_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE OPTATIVA ADD CONSTRAINT FK_OPTATIVA_REFERENCIA FOREIGN KEY (REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTES (NUM_EXPEDIENTE)
ALTER TABLE EXPEDIENTES ADD CONSTRAINT FK_EXPEDIENTES_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE EXPEDIENTES ADD CONSTRAINT FK_EXPEDIENTES_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_EXPEDIENTES_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTES_NUM_EXPEDIENTE) REFERENCES EXPEDIENTES (NUM_EXPEDIENTE)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_grupoID FOREIGN KEY (grupoID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_REFERENCIA_REFERENCIA FOREIGN KEY (REFERENCIA_REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_ID_ID FOREIGN KEY (ID_ID) REFERENCES GRUPO (ID)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE jn_tit_cntr ADD CONSTRAINT FK_jn_tit_cntr_centro_fk FOREIGN KEY (centro_fk) REFERENCES CENTRO (ID)
ALTER TABLE jn_tit_cntr ADD CONSTRAINT FK_jn_tit_cntr_tit_fk FOREIGN KEY (tit_fk) REFERENCES TITULACION (CODIGO)
ALTER TABLE jn_tit_opt ADD CONSTRAINT FK_jn_tit_opt_titulaciones_CODIGO FOREIGN KEY (titulaciones_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE jn_tit_opt ADD CONSTRAINT FK_jn_tit_opt_optativa_REFERENCIA FOREIGN KEY (optativa_REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE jn_enc_grpXasi ADD CONSTRAINT FK_jn_enc_grpXasi_FECHA_DE_ENVIO FOREIGN KEY (FECHA_DE_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES ENCUESTA (FECHA_DE_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE)
ALTER TABLE jn_enc_grpXasi ADD CONSTRAINT FK_jn_enc_grpXasi_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, ID_ID, REFERENCIA_REFERENCIA) REFERENCES GRUPOS_POR_ASIGNATURA (CURSO_ACADEMICO, ID_ID, REFERENCIA_REFERENCIA)
ALTER TABLE MATRICULA_ASIGNATURAS ADD CONSTRAINT MATRICULAASIGNATURASListado_Asignaturas_REFERENCIA FOREIGN KEY (Listado_Asignaturas_REFERENCIA) REFERENCES ASIGNATURAS (REFERENCIA)
ALTER TABLE MATRICULA_ASIGNATURAS ADD CONSTRAINT FK_MATRICULA_ASIGNATURAS_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTE)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)