package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionExpedientes;
import es.uma.informatica.ejb.proyecto.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.sii.anotaciones.Requisitos;




public class ExpedientesT {
	
	private static final Logger LOG = Logger.getLogger(ExpedientesT.class.getCanonicalName());
	
	private static final String EXPEDIENTES_EJB = "java:global/classes/ExpedientesEJB";
//	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
//	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
//	private static EJBContainer ejbContainer;
//	private static Context ctx;
	
	private GestionExpedientes gestionExpedientes;
	
//	@BeforeClass
//	public static void setUpClass() {
//		Properties properties = new Properties();
//		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
//		ejbContainer = EJBContainer.createEJBContainer(properties);
//		ctx = ejbContainer.getContext();
//	}
	
	@Before
	public void setup() throws NamingException  {
		gestionExpedientes = (GestionExpedientes) SuiteTest.ctx.lookup(EXPEDIENTES_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF8"})
	@Test
	public void testLeerNotaMedia() {
		try {
			double NotaMedia = gestionExpedientes.leerNotaMedia(104101303L);
			assertEquals(5,NotaMedia);
		}catch(SecretariaException e){
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testLeerNotaMediaExpedienteNoEncontradoException() {
		final long exp = 000000000L;
		try {
			double notaMedia = gestionExpedientes.leerNotaMedia(exp);
		}catch(ExpedienteNoEncontradoException e) {
			//OK
		}catch(SecretariaException e) {
			fail("Deberia lanzar excepcion de expediente no encontrado");
		}
	}
	@Requisitos({"RF8"})
	@Test
	public void testBorrarNotaMedia() {
		try {
			final long exp = 123456789L;
			gestionExpedientes.borrarNotaMedia(exp);
			
			assertEquals(null, gestionExpedientes.leerNotaMedia(exp));
		}catch(SecretariaException e){
			fail("No deberia lanzar la excepcion");
		}
	}
	
	@Test
	public void testBorrarNotaMediaExpedienteNoEncontradoException() {
		try {
			final long exp = 000000000L;
			gestionExpedientes.borrarNotaMedia(exp);
		}catch(ExpedienteNoEncontradoException e) {
			//OK
		}catch(SecretariaException e) {
			fail("Deberia lanzar excepcion de expediente no encontrado");
		}
	}
	@Requisitos({"RF8"})
	@Test
	public void testCambiarNotaMedia() {
		final long exp = 123456789L;
		final double notaM = 7.8;
		
		try {
			double NotaMedia = gestionExpedientes.leerNotaMedia(exp);
			gestionExpedientes.cambiarNotaMedia(exp, notaM);
			assertEquals(notaM, gestionExpedientes.leerNotaMedia(exp));
		}catch(SecretariaException e) {
			fail("Se lanza excepcion al actualizar");
		}
	}
	
	@Test
	public void testCambiarNotaMediaExpedienteNoEncontradoException() {
		final long exp = 000000000L;
		
		try {
			gestionExpedientes.borrarNotaMedia(exp);
		}catch(ExpedienteNoEncontradoException e) {
			//ok
		}catch(SecretariaException e) {
			fail("Deberia lanzar excepcion de expediente no encontrado");
		}
	}
	
//	@AfterClass
//	public static void tearDownClass() {
//		if (ejbContainer != null) {
//			ejbContainer.close();
//		}
//	}
}

