package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionAlumnos;
import es.uma.informatica.ejb.proyecto.excepciones.AlumnoNoEncontradoException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Alumno;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class AlumnoT {
	private static final Logger LOG = Logger.getLogger(AlumnoT.class.getCanonicalName());
	
	private static final String ALUMNOS_EJB = "java:global/classes/AlumnosEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	
	private GestionAlumnos gestionAlumnos;
	
	
	@Before
	public void setup() throws NamingException  {
		gestionAlumnos = (GestionAlumnos) SuiteTest.ctx.lookup(ALUMNOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF4"})
	@Test
	public void testLecturaAlumno() {
		try {
			Alumno alumno = gestionAlumnos.LecturaAlumno("213456789");
			assertEquals("Paco",alumno.getNombre());
			
		}catch(SecretariaException e) {
			fail("No deberia lanzar una excepcion");
			
		}
	}
	
	@Test
	public void testLecturaAlumnoNoEncontrado() {
		try {
			//no se encuentra en la bd
			Alumno alumno = gestionAlumnos.LecturaAlumno("321456789L");
			fail("debera lanzar excepcion alumno no encontrado");
		}catch(AlumnoNoEncontradoException e) {
			//OK
		}catch(SecretariaException e) {
			fail("debera lanzar excepcion alumno no encontrado");
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testActualizarAlumno() {
		final String ID = "213456789L";
		
		final String nombreAlumno = "Pepe";
		final String apellido1 = "Garcia";
		final String apellido2 = "Palotes";
		final String email_inst = "pepe@uma.es";
		
		try {
			Alumno alumno = gestionAlumnos.LecturaAlumno(ID);
			alumno.setApellido1(apellido1);
			alumno.setApellido2(apellido1);
			alumno.setNombre(nombreAlumno);
			alumno.setEmail_institucional(email_inst);
			
			gestionAlumnos.ActualizarAlumno(ID, alumno);
			
		}catch(SecretariaException e) {
			fail("Lanza excepcion al actualizar");
			
		}
				
		try {
			final String IDActualizado = "213456789L";
			Alumno alumnoActualizado = gestionAlumnos.LecturaAlumno(IDActualizado);
			
			assertTrue(nombreAlumno.compareTo(alumnoActualizado.getNombre())==0);
			assertTrue(apellido1.compareTo(alumnoActualizado.getApellido1())==0);
			assertTrue(apellido2.compareTo(alumnoActualizado.getApellido2())==0);
			assertTrue(email_inst.compareTo(alumnoActualizado.getEmail_institucional())==0);
			
		}catch(SecretariaException e) {
			fail("No deberia lanzar excepcion");
		}
		
	}
	
	@Test
	public void testActualizarAlumnoNoEncontrado() {
		final String ID = "111456789L";
		
		final String nombreAlumno = "Pepe";
		final String apellido1 = "Garcia";
		final String apellido2 = "Palotes";
		
		try {
			Alumno alumno = gestionAlumnos.LecturaAlumno(ID);
			alumno.setApellido1(apellido1);
			alumno.setApellido2(apellido1);
			alumno.setNombre(nombreAlumno);
			
			gestionAlumnos.ActualizarAlumno(ID, alumno);
			fail("Deberia  lanzar excepcion alumno no encontrado");
		}catch(AlumnoNoEncontradoException e) {
			//OK
			
		}catch(SecretariaException e) {
			fail("Deberia  lanzar excepcion alumno no encontrado");
		}
	}
	
	@Requisitos({"RF4"})
	@Test
	public void testEliminarAlumno() throws SecretariaException {
		final String ID = "213456789L";
			
			gestionAlumnos.EliminarAlumno(ID);
			assertThrows(AlumnoNoEncontradoException.class, ()->gestionAlumnos.LecturaAlumno(ID));
		
	}
	
	@Test
	public void testEliminarAlumnoNoEncontrado() {
		try {
			final String ID = "111456789L";
			gestionAlumnos.EliminarAlumno(ID);
			
			Alumno alumno2 = gestionAlumnos.LecturaAlumno(ID);
			
			assertEquals(null,alumno2.getID());
			fail("Deberia  lanzar excepcion alumno no encontrado");
		}catch(AlumnoNoEncontradoException e) {
			//OK
		}catch(SecretariaException e) {
		
			fail("Deberia  lanzar excepcion alumno no encontrado");
		}
	}
	
	
	

}
