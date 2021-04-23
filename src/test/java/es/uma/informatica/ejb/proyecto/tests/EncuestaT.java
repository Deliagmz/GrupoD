package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Timestamp;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionEncuestaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoValidoException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.sii.anotaciones.Requisitos;


public class EncuestaT {
	
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
		Expedientes nExp = new Expedientes();
		nExp.setNum_Expediente(123456789L);
		
		Encuesta encuesta = new Encuesta();
		encuesta.setFecha_de_envio(t);
		encuesta.setExpediente(nExp);
		try {
			gestionEncuesta.crearEncuesta(t, nExp);
			Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
			
			assertTrue(t.compareTo(enc.getFecha_de_envio())==0);
			
		}catch(EncuestaNoValidoException e) {
			fail("Los valores para encuestaID no son validos");
		}catch(SecretariaException e) {
			fail("no deberia dar error");
		}
	}
	@Requisitos({"RF11"})
	@Test
	public void testLeerEncuesta() {
		try {
			Timestamp t = java.sql.Timestamp.valueOf("2021-10-23 10:10:10.0");
			Expedientes nExp = new Expedientes();
			nExp.setNum_Expediente(123456789L);
			
			Encuesta encuesta = new Encuesta();
			encuesta.setFecha_de_envio(t);
			encuesta.setExpediente(nExp);
			
			Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
			
			assertEquals(
					 "Encuesta [fecha_de_envio=" + t + ", expediente=" + nExp + "]", enc);
			
		}catch(SecretariaException e) {
			fail("no deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testLeerEncuestaFail() {
		try {
			Timestamp t = java.sql.Timestamp.valueOf("2021-10-23 10:10:10.0");
			Expedientes nExp = new Expedientes();
			nExp.setNum_Expediente(123456769L);
			
			Encuesta encuesta = new Encuesta();
			encuesta.setFecha_de_envio(t);
			encuesta.setExpediente(nExp);
			
			Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
			
			
			
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
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456789L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);
		
		
		Timestamp t1 = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Expedientes exp1 = new Expedientes();
		exp1.setNum_Expediente(123789456L);
		
		Encuesta encuesta2 = new Encuesta();
		encuesta2.setExpediente(exp1);
		encuesta2.setFecha_de_envio(t1);
		
		
		try {
			gestionEncuesta.actualizarEncuesta(encuesta1, encuesta2.getFecha_de_envio(), encuesta2.getExpediente());
			
			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuesta1);
			
			assertEquals(
					 "Encuesta [fecha_de_envio=" + t1 + ", expediente=" + exp1 + "]", encuesta);
			
		}catch(SecretariaException e) {
			fail("no deberia lanzar excepcion");
		}
		
	}
	
	@Test
	public void testActualizarEncuestaNoEncontrada() {
		
		Timestamp t = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456999L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);
		
		
		Timestamp t1 = java.sql.Timestamp.valueOf("2021-09-23 10:10:10.0");
		Expedientes exp1 = new Expedientes();
		exp1.setNum_Expediente(123789456L);
		
		Encuesta encuesta2 = new Encuesta();
		encuesta2.setExpediente(exp1);
		encuesta2.setFecha_de_envio(t1);
		
		
		try {
			gestionEncuesta.actualizarEncuesta(encuesta1, t1, exp1);
			
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
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456999L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);
		
        try {
            
        	gestionEncuesta.borrarEncuesta(encuesta1);
        	
        	Encuesta encuesta = gestionEncuesta.leerEncuesta(encuesta1);
        	assertEquals(null,encuesta);
        	
        }catch(EncuestaNoEncontradaException e){
            //OK
        }catch(SecretariaException e){
            fail("Deberia lanzar encuesta no encontrada exception");
        }
    }
}
