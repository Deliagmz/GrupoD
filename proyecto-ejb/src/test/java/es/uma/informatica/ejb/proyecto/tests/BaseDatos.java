package es.uma.informatica.ejb.proyecto.tests;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.proyecto.Alumno;
import es.uma.informatica.jpa.proyecto.Asignaturas;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Titulacion;



public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
	
		em.getTransaction().begin();
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Paco");
		alumno.setID(213456789L);
		alumno.setApellido1("luna");
		alumno.setApellido2("sol");
		alumno.setDNI("789456123X");
		alumno.setEmail_institucional("paco@uma.es");
		
		em.persist(alumno);
		
		Asignaturas asignatura = new Asignaturas();
		asignatura.setReferencia(12345);
		asignatura.setCodigo(1111111);
		asignatura.setCreditos(6);
//		asignatura.setOfertada(true);
		asignatura.setNombre("Matematica discreta");
		
		em.persist(asignatura);
		
		Titulacion titulacion = new Titulacion();
		titulacion.setCodigo(1234);
		titulacion.setCreditos(240);
		titulacion.setNombre("Informatica");
		
		em.persist(titulacion);
		
		Expedientes expedientes = new Expedientes();
		expedientes.setNum_Expediente(123456789L);
		expedientes.setNota_Media_Provisional(5.0);
		
		em.persist(expedientes);
		
		Encuesta encuesta = new Encuesta();
		
		Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		encuesta.setFecha_de_envio(t);
		encuesta.setExpediente(expedientes);
		
		em.persist(encuesta);
		
		Matricula matricula = new Matricula();
		matricula.setCurso_academico("1");
		matricula.setEstado("activo");
		matricula.setExpedientes(expedientes);
		Date fecha = java.sql.Date.valueOf("2021-09-23");
		matricula.setFecha_de_matricula(fecha);

		
		
		em.persist(matricula);
		
		
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
