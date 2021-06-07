package es.uma.informatica.ejb.proyecto;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.proyecto.excepciones.AlumnoNoEncontradoException;
import es.uma.informatica.jpa.proyecto.Alumno;

@Stateless
public class AlumnosEJB implements GestionAlumnos{
	
	private static final Logger LOG = Logger.getLogger(AlumnosEJB.class.getCanonicalName());
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	public Alumno LecturaAlumno(String Id)throws AlumnoNoEncontradoException{
		
		Alumno alumno = em.find(Alumno.class, Id);
		if(alumno == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		return alumno;
		
	}
	
	public void ActualizarAlumno(String Id, Alumno alumno)throws AlumnoNoEncontradoException{
		Alumno alumnoExistente = em.find(Alumno.class, Id);
		if(alumnoExistente == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		
		alumnoExistente.setCodigo_postal(alumno.getCodigo_postal());
		alumnoExistente.setDireccion(alumno.getDireccion());
		
		alumnoExistente.setEmail_institucional(alumno.getEmail_institucional());
		alumnoExistente.setEmail_personal(alumno.getEmail_personal());
		alumnoExistente.setLocalidad(alumno.getLocalidad());
		alumnoExistente.setMovil(alumno.getMovil());
		alumnoExistente.setProvincia(alumno.getProvincia());
		alumnoExistente.setTelefono(alumno.getTelefono());
		
		em.persist(alumnoExistente);
		
	}
	
	public void EliminarAlumno(String id)throws AlumnoNoEncontradoException {
		Alumno alumnoExistente = em.find(Alumno.class, id);
		if(alumnoExistente == null) {
			throw new AlumnoNoEncontradoException();
		}
		em.remove(alumnoExistente);
	
	}
	
}
