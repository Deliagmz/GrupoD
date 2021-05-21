package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionExpedientes;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.sii.anotaciones.Requisitos;




public class ExpedientesT {
	
	private static final Logger LOG = Logger.getLogger(ExpedientesT.class.getCanonicalName());
	
	private static final String EXPEDIENTES_EJB = "java:global/classes/ExpedientesEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	
	private GestionExpedientes gestionExpedientes;
	
	@Before
	public void setup() throws NamingException  {
		gestionExpedientes = (GestionExpedientes) SuiteTest.ctx.lookup(EXPEDIENTES_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Requisitos({"RF8"})
	@Test
	public void testLeerNotaMedia() {
		try {
			double NotaMedia = gestionExpedientes.leerNotaMedia(123456789L);
			assertEquals(5.0,NotaMedia,0);
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
	public void testBorrarNotaMedia() throws SecretariaException {
		final long exp = 123456789L;
		
		
			gestionExpedientes.borrarNotaMedia(exp);
			assertThrows(ExpedienteNoEncontradoException.class, ()->gestionExpedientes.leerNotaMedia(exp));
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
			assertEquals(notaM, gestionExpedientes.leerNotaMedia(exp),0);
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
	
}

