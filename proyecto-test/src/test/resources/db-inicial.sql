
insert into `Usuario`values ('Secretaria', 'secretaria', 'secretaria', '00000000x', 'uma','uma@uma.es','secretaria',NULL,'666777888'),('Pepe','Pepon','pepaso','12345678x','micasa','pepe@uma.es','PepeLu',NULL,'666777888');

insert into `Alumno` values ('1','Gonzalez',NULL,NULL,'12345678x',NULL,'pepito@uma.es',NULL,NULL,NULL,'Pepito',NULL,NULL);

insert into `Asignaturas` values (11223344,NULL,111,6,NULL,NULL,NULL,'Estructura de Datos','Si',NULL,NULL);

insert into `Titulacion` values (1041,240,'Ingenieria Informatica'),(1042,240,'Ingenieria de la Salud');

insert into `Expedientes` values (123456789,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7.0,1,NULL),(987654321,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7.0,NULL,NULL);

insert into `Matricula` values ('20/21','activo','2010-01-10 20:20:20',NULL,NULL,NULL,123456789),('20/21','activo','2010-01-10 20:20:20',NULL,NULL,NULL,987654321);

DELETE FROM `hibernate_sequence`;
INSERT INTO `hibernate_sequence` VALUES (9);



