package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.EncuestaEJB;
import es.uma.informatica.ejb.proyecto.GestionEncuestaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaIdNoValidoException;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;
import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.jpa.proyecto.Expedientes;


public class EncuestaTest {
	
	private static final String ENCUESTA_EJB = "java:global/classes/EncuestaEJB";
//	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
//	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
//	private static EJBContainer ejbContainer;
//	private static Context ctx;
	
	private GestionEncuestaEJB gestionEncuesta;
	
//	@BeforeClass
//	public static void setUpClass() {
//		Properties properties = new Properties();
//		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
//		ejbContainer = EJBContainer.createEJBContainer(properties);
//		ctx = ejbContainer.getContext();
//	}
	
	@Before
	public void setup() throws NamingException  {
		gestionEncuesta = (GestionEncuestaEJB) SuiteTest.ctx.lookup(ENCUESTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF11"})
	@Test
	public void testCrearEncuesta() {
		
		Timestamp t = java.sql.Timestamp.valueOf("2021-10-23 10:10:10.0");
		Long nExp = 123456889L;
		
		EncuestaId encuestaID = new EncuestaId(t,nExp);
		
		try {
			gestionEncuesta.crearEncuesta(t, nExp);
			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuestaID);
			
		}catch(EncuestaIdNoValidoException e) {
			fail("Los valores para encuestaID no son validos");
		}catch(SecretariaException e) {
			fail("no deberia dar error");
		}
	}
	@Requisitos({"RF11"})
	@Test
	public void testLeerEncuesta() {
		try {
			Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
			Long nExp = 123456789L;
			
			
			EncuestaId encuestaID = new EncuestaId(t,nExp);
			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuestaID);
			
			assertEquals(
					 "Encuesta [fecha_de_envio=" + t + ", expediente=" + nExp + "]", encuesta);
			
		}catch(SecretariaException e) {
			fail("no deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testLeerEncuestaFail() {
		try {
			Timestamp t = java.sql.Timestamp.valueOf("2009-09-23 10:10:10.0");
			Long nExp = 123456789L;
			
			
			EncuestaId encuestaID = new EncuestaId(t,nExp);
			
			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuestaID);
			
			fail("debe lanzar excepcion de no encontrar la encuesta");
			
		}catch(EncuestaNoEncontradaException e) {
			//ok
		}catch(SecretariaException e) {
			fail("deberia lanzar encuesta no encontrada");
		}
	}
	@Requisitos({"RF11"})
	@Test
	public void testActualizarEncuesta() {
		
		Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Long nExp = 123456789L;
		
		
		EncuestaId encuestaID = new EncuestaId(t,nExp);
		
		Timestamp t1 = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Long nExp1 = 113456789L;
		
		EncuestaId encuestaID1 = new EncuestaId(t1,nExp1);
		
		try {
			gestionEncuesta.actualizarEncuesta(encuestaID, t1, nExp1);
			
			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuestaID1);
			
			assertEquals(
					 "Encuesta [fecha_de_envio=" + t1 + ", expediente=" + nExp1 + "]", encuesta);
			
		}catch(SecretariaException e) {
			fail("no deberia lanzar excepcion");
		}
		
	}
	
	@Test
	public void testActualizarEncuestaNoEncontrada() {
		
		Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Long nExp = 123457789L;
		
		
		EncuestaId encuestaID = new EncuestaId(t,nExp);
		
		Timestamp t1 = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Long nExp1 = 113456789L;
		
		
		try {
			gestionEncuesta.actualizarEncuesta(encuestaID, t1, nExp1);
			
		}catch(EncuestaNoEncontradaException e) {
			//OK
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			fail("deberia lanzar excepcion encuesta no encontrada");
		}
		
	}
	@Requisitos({"RF11"})
	@Test
    public void testBorrarEncuesta() {

		Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Long nExp = 123457789L;
		
		
		EncuestaId encuestaID = new EncuestaId(t,nExp);
		
        try {
            
        	gestionEncuesta.borrarEncuesta(encuestaID);
        	
        	Encuesta encuesta = gestionEncuesta.leerEncuesta(encuestaID);
        	
        }catch(EncuestaNoEncontradaException e){
            //OK
        }catch(SecretariaException e){
            fail("Deberia lanzar encuesta no encontrada exception");
        }
    }
}
