package es.uma.informatica.ejb.proyecto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoValidoException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;

@Stateless
public class EncuestaEJB implements GestionEncuestaEJB{

	private static final Logger LOG = Logger.getLogger(EncuestaEJB.class.getCanonicalName());
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public Encuesta leerEncuesta(Encuesta encuesta) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuesta);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		return encuestaEntity;
	}

	@Override
	public void crearEncuesta(Timestamp f_d_e, Expedientes e) throws EncuestaNoValidoException {
		if(f_d_e == null || e == null) {
			throw new EncuestaNoValidoException();
		}	
		
		Encuesta encuesta = new Encuesta();
		encuesta.setFecha_de_envio(f_d_e);
		encuesta.setExpediente(e);
		List<String> curso = new ArrayList<>();
		List<String> grupo = new ArrayList<>();
		encuesta.setGrupo(grupo);
		encuesta.setCurso(curso);
		
		em.persist(encuesta);
	}

	@Override
	public void actualizarEncuesta(Encuesta encuesta,Timestamp f_d_e, Expedientes e,String curso,String grupo) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuesta);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		List<String> grupo2 = encuestaEntity.getGrupo();
		List<String> curso2 = encuestaEntity.getCurso();
		grupo2.add(curso);
		curso2.add(grupo);
		
		encuesta.setCurso(curso2);
		encuesta.setGrupo(grupo2);
		encuestaEntity.setFecha_de_envio(f_d_e);
		encuestaEntity.setExpediente(e);
		em.persist(encuestaEntity);
	}

	@Override
	public void borrarEncuesta(Encuesta encuesta) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuesta);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		em.remove(encuestaEntity);
	};
}
