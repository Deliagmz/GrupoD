-- Generado por Oracle SQL Developer Data Modeler 19.2.0.182.1216
--   en:        2021-04-06 11:19:23 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE alumno (
    id                    VARCHAR2(52) NOT NULL,
    dni                   VARCHAR2(20) NOT NULL,
    nombre                VARCHAR2(52) NOT NULL,
    email_institucional   VARCHAR2(52) NOT NULL,
    email_personal        VARCHAR2(52),
    teléfono              NUMBER,
    móvil                 NUMBER NOT NULL,
    apellido1             VARCHAR2(52) NOT NULL,
    apellido2             VARCHAR2(52),
    dirección             VARCHAR2(255)
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id );

ALTER TABLE alumno ADD CONSTRAINT alumno_dni_id_un UNIQUE ( dni,
                                                            id );

CREATE TABLE asignatura (
    referencia                        NUMBER(5) NOT NULL,
    código                            NUMBER(3) NOT NULL,
    créditos                          NUMBER(2) NOT NULL,
    ofertada                          CHAR(1) NOT NULL,
    nombre                            VARCHAR2(255) NOT NULL,
    curso                             NUMBER(1),
    carácter                          NUMBER(3),
    duración                          VARCHAR2(255),
    "Unidad_Temporal(Cuatrimestre)"   VARCHAR2(255),
    idiomas_de_impartición            VARCHAR2(255),
    titulación_codigo                 NUMBER(3) NOT NULL
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( referencia );

CREATE TABLE asignaturas_matricula (
    grupo_id                               VARCHAR2(255),
    asignatura_referencia                  NUMBER(5) NOT NULL,
    matricula_curso_academico              VARCHAR2(52) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    matricula_expedientes_num_expediente   NUMBER(9) NOT NULL,
    referencia                             NUMBER NOT NULL
);

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_pk PRIMARY KEY ( referencia,
                                                          matricula_curso_academico,
                                                          matricula_expedientes_num_expediente );

CREATE TABLE centro (
    id                VARCHAR2(52) NOT NULL,
    nombre            VARCHAR2(52) NOT NULL,
    dirección         VARCHAR2(52) NOT NULL,
    tlf_conserjería   NUMBER(20)
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id );

ALTER TABLE centro ADD CONSTRAINT centro_nombre_id_un UNIQUE ( nombre,
                                                               id );

CREATE TABLE clase (
    día                     VARCHAR2(20) NOT NULL,
    hora_inicio             DATE NOT NULL,
    hora_fin                DATE,
    optativa_referencia     NUMBER(5) NOT NULL,
    grupo_id                VARCHAR2(255) NOT NULL,
    asignatura_referencia   NUMBER(5) NOT NULL
);

ALTER TABLE clase
    ADD CONSTRAINT clase_pk PRIMARY KEY ( día,
                                          hora_inicio,
                                          grupo_id );

CREATE TABLE encuesta (
    fecha_de_envío               DATE NOT NULL,
    expedientes_num_expediente   NUMBER(9) NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( fecha_de_envío,
                                                              expedientes_num_expediente );

CREATE TABLE expedientes (
    num_expediente           NUMBER(9) NOT NULL,
    activo                   CHAR(1),
    nota_media_provisional   NUMBER(2, 2),
    titulación_codigo        NUMBER(3) NOT NULL,
    alumno_id                VARCHAR2(52) NOT NULL
);

ALTER TABLE expedientes ADD CONSTRAINT expedientes_pk PRIMARY KEY ( num_expediente );

CREATE TABLE grupo (
    id                   VARCHAR2(255) NOT NULL,
    curso                VARCHAR2(20) NOT NULL,
    letra                VARCHAR2(1) NOT NULL,
    turno_mañana_tarde   VARCHAR2(20) NOT NULL,
    plazas               NUMBER(3) NOT NULL,
    inglés               CHAR(1) NOT NULL,
    visible              CHAR(1),
    asignable            CHAR(1),
    titulación_codigo    NUMBER(3) NOT NULL,
    grupo_id             VARCHAR2(255),
    grupo_preferente     VARCHAR2(1)
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id );

ALTER TABLE grupo ADD CONSTRAINT grupo_curso_id_un UNIQUE ( curso,
                                                            id );

ALTER TABLE grupo ADD CONSTRAINT grupo_letra_id_un UNIQUE ( letra,
                                                            id );

CREATE TABLE grupos_por_asignatura (
    curso_academico         VARCHAR2(52) NOT NULL,
    oferta                  CHAR(1),
    grupo_id                VARCHAR2(255) NOT NULL,
    asignatura_referencia   NUMBER(5) NOT NULL,
    referencia              NUMBER NOT NULL
);

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_pk PRIMARY KEY ( curso_academico,
                                                          grupo_id,
                                                          referencia );

CREATE TABLE matricula (
    curso_academico              VARCHAR2(52) NOT NULL,
    estado                       VARCHAR2(20) NOT NULL,
    num_archivo                  NUMBER(9),
    turno_preferente             VARCHAR2(52),
    fecha_de_matricula           TIMESTAMP NOT NULL,
    nuevo_ingreso                CHAR(1),
    listado_asignaturas          VARCHAR2(255),
    expedientes_num_expediente   NUMBER(9) NOT NULL
);

ALTER TABLE matricula ADD CONSTRAINT matricula_pk PRIMARY KEY ( curso_academico,
                                                                expedientes_num_expediente );

CREATE TABLE optativa (
    referencia   NUMBER(5) NOT NULL,
    plazas       NUMBER NOT NULL,
    mención      VARCHAR2(50)
);

ALTER TABLE optativa ADD CONSTRAINT optativa_pk PRIMARY KEY ( referencia );

CREATE TABLE relation_13 (
    encuesta_fecha_de_envío                       DATE NOT NULL,
    encuesta_num_expediente                       NUMBER(9) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_curso_academico         VARCHAR2(52) NOT NULL,
    grupos_por_asignatura_id                      VARCHAR2(255) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_asignatura_referencia   NUMBER(5) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_referencia              NUMBER
);

ALTER TABLE relation_13
    ADD CONSTRAINT relation_13_pk PRIMARY KEY ( encuesta_fecha_de_envío,
                                                encuesta_num_expediente,
                                                grupos_por_asignatura_curso_academico,
                                                grupos_por_asignatura_id,
                                                grupos_por_asignatura_asignatura_referencia,
                                                grupos_por_asignatura_referencia );

CREATE TABLE relation_16 (
    titulación_codigo   NUMBER(3) NOT NULL,
    centro_id           VARCHAR2(52) NOT NULL
);

ALTER TABLE relation_16 ADD CONSTRAINT relation_16_pk PRIMARY KEY ( titulación_codigo,
                                                                    centro_id );

CREATE TABLE titulación (
    codigo     NUMBER(3) NOT NULL,
    créditos   NUMBER(2) NOT NULL,
    nombre     VARCHAR2(52) NOT NULL
);

ALTER TABLE titulación ADD CONSTRAINT titulación_pk PRIMARY KEY ( codigo );

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_titulación_fk FOREIGN KEY ( titulación_codigo )
        REFERENCES titulación ( codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_matricula_fk FOREIGN KEY ( matricula_curso_academico,
                                                                    matricula_expedientes_num_expediente )
        REFERENCES matricula ( curso_academico,
                               expedientes_num_expediente );

ALTER TABLE clase
    ADD CONSTRAINT clase_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE clase
    ADD CONSTRAINT clase_optativa_fk FOREIGN KEY ( optativa_referencia )
        REFERENCES optativa ( referencia );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_expedientes_fk FOREIGN KEY ( expedientes_num_expediente )
        REFERENCES expedientes ( num_expediente );

ALTER TABLE expedientes
    ADD CONSTRAINT expedientes_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE expedientes
    ADD CONSTRAINT expedientes_titulación_fk FOREIGN KEY ( titulación_codigo )
        REFERENCES titulación ( codigo );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titulación_fk FOREIGN KEY ( titulación_codigo )
        REFERENCES titulación ( codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE matricula
    ADD CONSTRAINT matricula_expedientes_fk FOREIGN KEY ( expedientes_num_expediente )
        REFERENCES expedientes ( num_expediente );

ALTER TABLE optativa
    ADD CONSTRAINT optativa_asignatura_fk FOREIGN KEY ( referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE relation_13
    ADD CONSTRAINT relation_13_encuesta_fk FOREIGN KEY ( encuesta_fecha_de_envío,
                                                         encuesta_num_expediente )
        REFERENCES encuesta ( fecha_de_envío,
                              expedientes_num_expediente );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE relation_13
    ADD CONSTRAINT relation_13_grupos_por_asignatura_fk FOREIGN KEY ( grupos_por_asignatura_curso_academico,
                                                                      grupos_por_asignatura_id,
                                                                      grupos_por_asignatura_referencia,
                                                                      grupos_por_asignatura_asignatura_referencia )
        REFERENCES grupos_por_asignatura ( curso_academico,
                                           grupo_id,
                                           referencia );

ALTER TABLE relation_16
    ADD CONSTRAINT relation_16_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

ALTER TABLE relation_16
    ADD CONSTRAINT relation_16_titulación_fk FOREIGN KEY ( titulación_codigo )
        REFERENCES titulación ( codigo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             0
-- ALTER TABLE                             38
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   8
-- WARNINGS                                 0
