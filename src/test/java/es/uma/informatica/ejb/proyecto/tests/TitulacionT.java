package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

import es.uma.informatica.ejb.proyecto.GestionTitulacion;
import es.uma.informatica.ejb.proyecto.TitulacionEJB;
import es.uma.informatica.ejb.proyecto.excepciones.MatriculaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.ejb.proyecto.excepciones.TitulacionNoEncontradaException;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;
import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.jpa.proyecto.Titulacion;

public class TitulacionT {
private static final Logger LOG = Logger.getLogger(TitulacionEJB.class.getCanonicalName());
	

	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
//	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
//	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
//	private static EJBContainer ejbContainer;
//	private static Context ctx;
	
	private GestionTitulacion gestionTitulacion;
	
//	@BeforeClass
//	public static void setUpClass() {
//		Properties properties = new Properties();
//		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
//		ejbContainer = EJBContainer.createEJBContainer(properties);
//		ctx = ejbContainer.getContext();
//	}
	
	@Before
	public void setup() throws NamingException  {
		gestionTitulacion= (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF6"})
	@Test
	public void testObtenerTitulacion() {
		try {
			Titulacion titulacion =gestionTitulacion.obtenerTitulacion(1234);
			Integer codigo=1234;
			assertEquals(titulacion.getCodigo(),codigo);
		}catch(SecretariaException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testObtenerTitulacionNoEncontrada() {
		try {
			Titulacion titulacion =gestionTitulacion.obtenerTitulacion(1245);
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		} catch (TitulacionNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		}
	}
	@Requisitos({"RF6"})
	@Test
	public void testActualizarTitulacion() {
		
		try {
			Titulacion titulacion =gestionTitulacion.obtenerTitulacion(1234);
			Integer codigoTitulacion = titulacion.getCodigo();
			titulacion.setCreditos(145);
			titulacion.setNombre("Computadores");
			gestionTitulacion.actualizarTitulacion(codigoTitulacion, titulacion);
		}catch (SecretariaException e) {
			fail("Lanza excepcion al actualizar");
		}
		
		try {
			Titulacion titulacionActualizada =gestionTitulacion.obtenerTitulacion(1234);
			assertEquals(titulacionActualizada.getCreditos(),(Integer)145);
			assertEquals(titulacionActualizada.getNombre(),"Computadores");
		} catch (SecretariaException e) {
			fail("No deberia lanzar excepcion");
		}
		
	}
	
	@Test
	public void testActualizarTitulacionNoEncontrada() {
		try {
			Titulacion titulacion =gestionTitulacion.obtenerTitulacion(1234);
			Integer codigoTitulacion = titulacion.getCodigo();
			titulacion.setCreditos(145);
			titulacion.setNombre("Computadores");
			gestionTitulacion.actualizarTitulacion(1245, titulacion);;
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		} catch (TitulacionNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		}
		
	}
	@Requisitos({"RF6"})
	@Test
	public void testEliminarTitulacion() {
		try {
			Titulacion titulacion =gestionTitulacion.obtenerTitulacion(1234);
			
			gestionTitulacion.eliminarTitulacion(1234);
			
			assertEquals(null,titulacion.getCodigo());
			assertEquals(null,titulacion.getNombre());
			assertEquals(null,titulacion.getCreditos());
			
			
			
		} catch (SecretariaException e) {
			fail("No deberia lanzarse excepcion");
		}
	}
	
	@Test
	public void testEliminarTitulacionNoEncontrada() {
		try {
			gestionTitulacion.eliminarTitulacion(1245);
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		} catch (TitulacionNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de titulacion no encontrada");
		}
	}
	
	
	
//	@AfterClass
//	public static void tearDownClass() {
//		if (ejbContainer != null) {
//			ejbContainer.close();
//		}
//	}

	
}
