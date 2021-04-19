package es.uma.informatica.ejb.proyecto;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.jpa.proyecto.Asignaturas;

@Stateless
public class AsignaturasEJB implements GestionAsignaturas{
	private static final Logger LOG = Logger.getLogger(AsignaturasEJB.class.getCanonicalName());
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public Asignaturas obtenerAsignatura (Integer referencia) throws AsignaturaNoEcontradaException{
		Asignaturas asignaturaEntity = em.find(Asignaturas.class, referencia);
		if(asignaturaEntity==null) {
			throw new AsignaturaNoEncontradaException();
		}
		return asignaturaEntity;
	}
	
	@Override
	public void actualizarAsignatura (Integer referencia, Asignaturas asig) throws AsignaturaNoEncontradaException{
		Asignaturas asignaturaEntity = em.find(Asignaturas.class, referencia);
		if(asignaturaEntity==null) {
			throw new AsignaturaNoEncontradaException();
		}
		asignaturaEntity.setCaracter(asig.getCaracter());
		asignaturaEntity.setNombre(asig.getNombre());
		asignaturaEntity.setCurso(asig.getCurso());
		asignaturaEntity.setDuracion(asig.getDuracion());
		asignaturaEntity.setUnidad_Temporal(asig.getUnidad_Temporal());
		asignaturaEntity.setIdiomas_Imparticion(asig.getIdiomas_Imparticion());
		asignaturaEntity.setOfertada(asig.getOfertada());
		asignaturaEntity.setCodigo(asig.getCodigo());
		
		em.persist(asignaturaEntity);
		
	}
	
	@Override
	public void eliminarAsignatura(Integer referencia) throws AsignaturaNoEncontradaException{
		Asignaturas asignaturaEntity = em.find(Asignaturas.class, referencia);
		if(asignaturaEntity==null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.remove(asignaturaEntity);
	}
	
	
}
