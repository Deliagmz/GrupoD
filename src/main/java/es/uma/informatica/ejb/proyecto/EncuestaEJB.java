package es.uma.informatica.ejb.proyecto;

import java.sql.Timestamp;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;

@Stateless
public class EncuestaEJB implements GestionEncuestaEJB{

	private static final Logger LOG = Logger.getLogger(EncuestaEJB.class.getCanonicalName());
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public String leerEncuesta(EncuestaId encuestaID) throws EncuestaNoEncontradaException {
		// TODO Auto-generated method stub
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaID);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		String encuesta = encuestaEntity.getFecha_de_envio().toString() + encuestaEntity.getExpediente();
		
		return encuesta;
	}

	@Override
	public void crearEncuesta(Timestamp f_d_e, Expedientes e) throws EncuestaIdNoValidoException {
		// TODO Auto-generated method stub
		if(f_d_e == null || e == null) {
			throw new EncuestaIdNoValidoException();
		}
		
		Encuesta encuesta;
		
		encuesta.setFecha_de_envio(f_d_e);
		encuesta.setExpediente(e);
		
		em.merge(encuesta);
	}

	@Override
	public void actualizarEncuesta(EncuestaId encuestaID,Timestamp f_d_e, Expedientes e) throws EncuestaNoEncontradaException {
		// TODO Auto-generated method stub
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaID);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		encuestaEntity.setFecha_de_envio(f_d_e);
		encuestaEntity.setExpediente(e);
		em.persist(encuestaEntity);
	}

	@Override
	public void borrarEncuesta(EncuestaId encuestaID) throws EncuestaNoEncontradaException {
		// TODO Auto-generated method stub
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaID);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		em.remove(encuestaEntity);
	};
}
