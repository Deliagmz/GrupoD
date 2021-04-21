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

public class MatriculaTest {
	private static final Logger LOG = Logger.getLogger(MatriculaEJB.class.getCanonicalName());
	

	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
//	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
//	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
//	private static EJBContainer ejbContainer;
//	private static Context ctx;
	
	private GestionMatricula gestionMatricula;
	
//	@BeforeClass
//	public static void setUpClass() {
//		Properties properties = new Properties();
//		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
//		ejbContainer = EJBContainer.createEJBContainer(properties);
//		ctx = ejbContainer.getContext();
//	}
//	
	@Before
	public void setup() throws NamingException  {
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
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
	
//	@AfterClass
//	public static void tearDownClass() {
//		if (ejbContainer != null) {
//			ejbContainer.close();
//		}
//	}

}
