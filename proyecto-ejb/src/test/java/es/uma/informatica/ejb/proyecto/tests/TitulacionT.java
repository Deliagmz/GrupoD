package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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
import es.uma.informatica.ejb.proyecto.excepciones.AlumnoNoEncontradoException;
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
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	
	private GestionTitulacion gestionTitulacion;
	
	
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
            assertEquals(titulacion.getNombre(),"Informatica");
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
	public void testEliminarTitulacion() throws SecretariaException {
		Integer codigo = 1234;
		gestionTitulacion.eliminarTitulacion(codigo);
		assertThrows(TitulacionNoEncontradaException.class, ()->gestionTitulacion.obtenerTitulacion(codigo));

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
		
}