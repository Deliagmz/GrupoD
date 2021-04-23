package es.uma.informatica.ejb.proyecto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.proyecto.GestionAsignaturas;
import es.uma.informatica.ejb.proyecto.excepciones.AsignaturaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Asignaturas;
import es.uma.informatica.sii.anotaciones.Requisitos;




public class AsignaturasT {
	private static final Logger LOG = Logger.getLogger(AsignaturasT.class.getCanonicalName());
	
	private static final String ASIGNATURAS_EJB = "java:global/classes/AsignaturasEJB";
//	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
//	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
//	private static EJBContainer ejbContainer;
//	private static Context ctx;
//	
	private GestionAsignaturas gestionAsignaturas;
	
//	@BeforeClass
//	public static void setUpClass() {
//		Properties properties = new Properties();
//		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
//		ejbContainer = EJBContainer.createEJBContainer(properties);
//		ctx = ejbContainer.getContext();
//	}
	
	@Before
	public void setup() throws NamingException  {
		gestionAsignaturas = (GestionAsignaturas) SuiteTest.ctx.lookup(ASIGNATURAS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF5"})
	@Test
	public void testObtenerAsignaturas() {
		try {
			Asignaturas asignatura = gestionAsignaturas.obtenerAsignatura(12345);
			assertEquals("Matematica discreta", asignatura.getNombre());
		} catch (SecretariaException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testObtenerAsignaturasNoEncontrado() {
		try {
			Asignaturas asignatura = gestionAsignaturas.obtenerAsignatura(56789);
			fail("Deberia lanzar excepcion de asignatura no encontrada");
		} catch (AsignaturaNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de asignatura no encontrada");
		}
	}
	@Requisitos({"RF5"})
	@Test
	public void testActualizarAsignatura() {
			
			
			
			final String nuevoCurso = "2";
			final String nuevoCaracter = "Optativa";
			final String nuevaDuracion = "2º Semestre";
			final String nuevoIdiomas_imparticion = "ingles";
			
			Integer referenciaAsignatura = null;
			
			try {
				
				Asignaturas asignatura = gestionAsignaturas.obtenerAsignatura(12345);
				
				referenciaAsignatura = asignatura.getReferencia();
				
				asignatura.setCurso(nuevoCurso);
				asignatura.setCaracter(nuevoCaracter);
				asignatura.setDuracion(nuevaDuracion);
				asignatura.setIdiomas_Imparticion(nuevoIdiomas_imparticion);
				
				
				gestionAsignaturas.actualizarAsignatura(referenciaAsignatura, asignatura);
	
			} catch (SecretariaException e) {
				fail("Lanza excepcion al actualizar");
			}
	
	
			try {
				final Integer referenciaAsignaturaActualizada = referenciaAsignatura;
				Asignaturas asignaturaActualizada = gestionAsignaturas.obtenerAsignatura(referenciaAsignaturaActualizada);
				
				assertTrue(nuevoCurso.compareTo(asignaturaActualizada.getCurso())==0);
				assertTrue(nuevoCaracter.compareTo(asignaturaActualizada.getCaracter())==0);
				assertTrue(nuevaDuracion.compareTo(asignaturaActualizada.getDuracion())==0);
				assertTrue(nuevoIdiomas_imparticion.compareTo(asignaturaActualizada.getIdiomas_Imparticion())==0);
				
				
			} catch (SecretariaException e) {
				fail("No deberia lanzar excepcion");
			}
		}
	
	@Test
	public void testActualizarAsignaturaNoEncontrada() {
		final Integer otraAsignatura = 45678;
		
		final String nuevoCurso = "2";
		final String nuevoCaracter = "Optativa";
		final String nuevaDuracion = "2º Semestre";
		final String nuevoIdiomas_imparticion = "ingles";
		
		
		try {
			Asignaturas asignatura = gestionAsignaturas.obtenerAsignatura(12345);
			
			
			
			asignatura.setCurso(nuevoCurso);
			asignatura.setCaracter(nuevoCaracter);
			asignatura.setDuracion(nuevaDuracion);
			asignatura.setIdiomas_Imparticion(nuevoIdiomas_imparticion);
			
			
			gestionAsignaturas.actualizarAsignatura(otraAsignatura, asignatura);
			fail("Deberia lanzar excepcion de asignatura no encontrada");
		} catch (AsignaturaNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar excepcion de asignatura no encontrada");
		}
	}
	@Requisitos({"RF5"})
	@Test
    public void testBorrarAsignatura() {
		 final Integer ref = 12345;
		 
		try {
			Asignaturas asig = gestionAsignaturas.obtenerAsignatura(ref);
            gestionAsignaturas.eliminarAsignatura(ref);

           
            
            assertNull(asig);
        }catch(SecretariaException e){
            fail("No deberia lanzar la excepcion");
        }
    }
	
	@Test
	public void testEliminarAsignaturaNoEncontrada() {
		try {
			final Integer referencia = 12345;
			
			Asignaturas asignatura = gestionAsignaturas.obtenerAsignatura(referencia);
			
		
			asignatura.setReferencia(11111);

			gestionAsignaturas.eliminarAsignatura(11111);
			fail("Deberia lanzar la excepcion de asignatura no encontrada");
		} catch (AsignaturaNoEncontradaException e) {
			// OK
		} catch (SecretariaException e) {
			fail("Deberia lanzar la excepcion de asignatura no encontrada");
		}
	}
	

}
