package es.uma.informatica.ejb.proyecto;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.proyecto.excepciones.MatriculaNoEncontradaException;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;



public class MatriculaEJB implements GestionMatricula {
	
	private static final Logger LOG = Logger.getLogger(MatriculaEJB.class.getCanonicalName());
	
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public Matricula obtenerMatricula(MatriculaId matriculaId) throws MatriculaNoEncontradaException {
		Matricula matriculaEntity = em.find(Matricula.class, matriculaId);
		if (matriculaEntity == null) {
			throw new MatriculaNoEncontradaException();
		}
		return matriculaEntity;
	}
	
}
