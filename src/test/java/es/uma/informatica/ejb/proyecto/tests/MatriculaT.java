package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionMatricula;
import es.uma.informatica.ejb.proyecto.MatriculaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.MatriculaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class MatriculaT {
	private static final Logger LOG = Logger.getLogger(MatriculaEJB.class.getCanonicalName());
	

	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	
	private GestionMatricula gestionMatricula;
	
	@Before
	public void setup() throws NamingException  {
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF9"})
	@Test
	public void testObtenerMatricula() {
		try {
			MatriculaId mId= new MatriculaId("1", 123456789L);
			Matricula matricula =gestionMatricula.obtenerMatricula(mId);
			assertEquals(matricula.getCurso_academico(),"1");
		}catch(SecretariaException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testObtenerMatriculaNoEncontrada() {
		try {
			MatriculaId mId= new MatriculaId("1", 123456788L);
			Matricula matricula = gestionMatricula.obtenerMatricula(mId);
			fail("Deberia lanzar excepcion de matricula no encontrada");
		} catch (MatriculaNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de matricula no encontrada");
		}
	}
	

}
