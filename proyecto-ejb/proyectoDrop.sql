ALTER TABLE CLASE DROP CONSTRAINT FK_CLASE_GRUPOS_ID
ALTER TABLE CLASE DROP CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA
ALTER TABLE ASIGNATURAS DROP CONSTRAINT FK_ASIGNATURAS_TITULACION_CODIGO
ALTER TABLE OPTATIVA DROP CONSTRAINT FK_OPTATIVA_REFERENCIA
ALTER TABLE ENCUESTA DROP CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUM_EXPEDIENTE
ALTER TABLE EXPEDIENTES DROP CONSTRAINT FK_EXPEDIENTES_TITULACION_CODIGO
ALTER TABLE EXPEDIENTES DROP CONSTRAINT FK_EXPEDIENTES_ALUMNO_ID
ALTER TABLE MATRICULA DROP CONSTRAINT FK_MATRICULA_EXPEDIENTES_NUM_EXPEDIENTE
ALTER TABLE GRUPO DROP CONSTRAINT FK_GRUPO_grupoID
ALTER TABLE GRUPO DROP CONSTRAINT FK_GRUPO_TITULACION_CODIGO
ALTER TABLE GRUPOS_POR_ASIGNATURA DROP CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_REFERENCIA_REFERENCIA
ALTER TABLE GRUPOS_POR_ASIGNATURA DROP CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_ID_ID
ALTER TABLE ASIGNATURAS_MATRICULA DROP CONSTRAINT FK_ASIGNATURAS_MATRICULA_ASIGNATURA_REFERENCIA
ALTER TABLE ASIGNATURAS_MATRICULA DROP CONSTRAINT FK_ASIGNATURAS_MATRICULA_CURSO_ACADEMICO
ALTER TABLE ASIGNATURAS_MATRICULA DROP CONSTRAINT FK_ASIGNATURAS_MATRICULA_GRUPO_ID
ALTER TABLE jn_tit_opt DROP CONSTRAINT FK_jn_tit_opt_titulaciones_CODIGO
ALTER TABLE jn_tit_opt DROP CONSTRAINT FK_jn_tit_opt_optativa_REFERENCIA
ALTER TABLE jn_tit_cntr DROP CONSTRAINT FK_jn_tit_cntr_centro_fk
ALTER TABLE jn_tit_cntr DROP CONSTRAINT FK_jn_tit_cntr_tit_fk
ALTER TABLE jn_enc_grpXasi DROP CONSTRAINT FK_jn_enc_grpXasi_FECHA_DE_ENVIO
ALTER TABLE jn_enc_grpXasi DROP CONSTRAINT FK_jn_enc_grpXasi_CURSO_ACADEMICO
DROP TABLE ALUMNO
DROP TABLE CLASE
DROP TABLE ASIGNATURAS
DROP TABLE OPTATIVA
DROP TABLE CENTRO
DROP TABLE ENCUESTA
DROP TABLE EXPEDIENTES
DROP TABLE MATRICULA
DROP TABLE TITULACION
DROP TABLE GRUPO
DROP TABLE GRUPOS_POR_ASIGNATURA
DROP TABLE ASIGNATURAS_MATRICULA
DROP TABLE jn_tit_opt
DROP TABLE jn_tit_cntr
DROP TABLE jn_enc_grpXasi
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
