package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	
	private GestionEncuestaEJB gestionEncuesta;
	
	@Before
	public void setup() throws NamingException  {
		gestionEncuesta = (GestionEncuestaEJB) SuiteTest.ctx.lookup(ENCUESTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF11"})
	@Test
	public void testCrearEncuesta() {
		
		String t = "2021-10-23 10:10:10.0";
		Expedientes nExp = new Expedientes();
		nExp.setNum_Expediente(123456789L);
		
		Encuesta encuesta = new Encuesta();
		encuesta.setFecha_de_envio(t);
		encuesta.setExpediente(nExp);
//		try {
//			//gestionEncuesta.crearEncuesta(t, nExp);
//			//Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
//			
//			assertTrue(t.compareTo(enc.getFecha_de_envio())==0);
//			
//		}catch(EncuestaNoValidoException e) {
//			fail("Los valores para encuestaID no son validos");
//		}catch(SecretariaException e) {
//			fail("no deberia dar error");
//		}
	}
	@Requisitos({"RF11"})
	@Test
	public void testLeerEncuesta() {
//		try {
//			String t = "2021-10-23 10:10:10.0";
//			Expedientes nExp = new Expedientes();
//			nExp.setNum_Expediente(123456789L);
//			
//			Encuesta encuesta = new Encuesta();
//			encuesta.setFecha_de_envio(t);
//			encuesta.setExpediente(nExp);
//			
////			//Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
////			
////			assertEquals(encuesta, enc);
////			
////		}catch(SecretariaException e) {
////			fail("no deberia lanzar excepcion");
////		}
	}
	
	@Test
	public void testLeerEncuestaFail() {
//		try {
//			String t = "2021-10-23 10:10:10.0";
//			Expedientes nExp = new Expedientes();
//			nExp.setNum_Expediente(123478874L);
//			
//			Encuesta encuesta = new Encuesta();
//			encuesta.setFecha_de_envio(t);
//			encuesta.setExpediente(nExp);
//			
//			Encuesta enc = gestionEncuesta.leerEncuesta(encuesta);
//				
//			
//			fail("debe lanzar excepcion de no encontrar la encuesta");
//			
//		}catch(EncuestaNoEncontradaException e) {
//			//ok
//		}catch(SecretariaException e) {
//			fail("deberia lanzar encuesta no encontrada");
//		}
	}
	@Requisitos({"RF11"})
	@Test
	public void testActualizarEncuesta() {
		
		String t = "2021-09-23 10:10:10.0";
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456789L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);
		
		
		String t1 = "2021-09-23 10:10:10.0";
		Expedientes exp1 = new Expedientes();
		exp1.setNum_Expediente(123789456L);
		
		Encuesta encuesta2 = new Encuesta();
		encuesta2.setExpediente(exp1);
		encuesta2.setFecha_de_envio(t1);
		
		
//		try {
//			gestionEncuesta.actualizarEncuesta(encuesta1, encuesta2.getFecha_de_envio(), encuesta2.getExpediente());
//			
//			Encuesta encuesta = gestionEncuesta.leerEncuesta(encuesta1);
//			
//			assertEquals(encuesta1, encuesta);
//			
//		}catch(SecretariaException e) {
//			fail("no deberia lanzar excepcion");
//		}
		
	}
	
	@Test
	public void testActualizarEncuestaNoEncontrada() {
		
		String t ="2021-09-23 10:10:10.0";
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456999L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);
		
		
		String t1 = "2021-09-23 10:10:10.0";
		Expedientes exp1 = new Expedientes();
		exp1.setNum_Expediente(123789456L);
		
		Encuesta encuesta2 = new Encuesta();
		encuesta2.setExpediente(exp1);
		encuesta2.setFecha_de_envio(t1);
		
		
//		try {
//			gestionEncuesta.actualizarEncuesta(encuesta1, t1, exp1);
//			
//		}catch(EncuestaNoEncontradaException e) {
//			//OK
//		} catch (SecretariaException e) {
//			fail("deberia lanzar excepcion encuesta no encontrada");
//		}
		
	}
	@Requisitos({"RF11"})
	@Test
    public void testBorrarEncuesta() {

		String t = "2021-09-23 10:10:10.0";
		Expedientes exp = new Expedientes();
		exp.setNum_Expediente(123456999L);
		
		
		Encuesta encuesta1 = new Encuesta();
		encuesta1.setFecha_de_envio(t);
		encuesta1.setExpediente(exp);

//        try {
//        	gestionEncuesta.borrarEncuesta(encuesta1);
//        	assertThrows(EncuestaNoEncontradaException.class,()->gestionEncuesta.leerEncuesta(encuesta1));
//        	
//        }catch(EncuestaNoEncontradaException e){
//            //OK
//        }catch(SecretariaException e){
//            fail("Deberia lanzar encuesta no encontrada exception");
//        }
    }
}
