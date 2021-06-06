package es.uma.informatica.ejb.proyecto;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.proyecto.excepciones.TitulacionNoEncontradaException;
import es.uma.informatica.jpa.proyecto.Titulacion;

@Stateless
public class TitulacionEJB implements GestionTitulacion{
	
	private static final Logger LOG = Logger.getLogger(TitulacionEJB.class.getCanonicalName());
	
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public Titulacion obtenerTitulacion(Integer codigo) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, codigo);
		if(titulacionEntity==null) {
			throw new TitulacionNoEncontradaException();
		}
		return  titulacionEntity;
	}

	@Override
	public void eliminarTitulacion(Integer codigo) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, codigo);
		if(titulacionEntity==null) {
			throw new TitulacionNoEncontradaException();
		}
		em.remove(titulacionEntity);
		
	}

	@Override
	public void actualizarTitulacion(Integer codigo, Titulacion t) throws TitulacionNoEncontradaException {
		Titulacion titulacionEntity = em.find(Titulacion.class, codigo);
		if(titulacionEntity==null) {
			throw new TitulacionNoEncontradaException();
		}
		titulacionEntity.setNombre(t.getNombre());
		titulacionEntity.setCreditos(t.getCreditos());
		
	}
	
}
