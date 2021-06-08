package es.uma.informatica.ejb.proyecto;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoValidoException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;
import es.uma.informatica.jpa.proyecto.Expedientes;

@Stateless
public class EncuestaEJB implements GestionEncuestaEJB{

	private static final Logger LOG = Logger.getLogger(EncuestaEJB.class.getCanonicalName());
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public Encuesta leerEncuesta(EncuestaId encuestaId) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaId);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		return encuestaEntity;
	}

	public void crearEncuesta(Encuesta encuesta,EncuestaId encuestaId) throws EncuestaNoValidoException {	
		Encuesta encuestaEntity = new Encuesta();
		Expedientes expedienteEntity = em.find(Expedientes.class, encuestaId.getExpediente());
		
		encuestaEntity.setFecha_de_envio(encuestaId.getFecha_de_envio());
		encuestaEntity.setExpediente(expedienteEntity);
		
		if(encuesta.getGrupoPrimero().equals("1A")||encuesta.getGrupoPrimero().equals("1B")||encuesta.getGrupoPrimero().equals("1C")||encuesta.getGrupoPrimero().equals("1D")
					||encuesta.getGrupoPrimero().equals("1E")||encuesta.getGrupoPrimero().isEmpty()){
			encuestaEntity.setGrupoPrimero(encuesta.getGrupoPrimero());
		}else {
			throw new EncuestaNoValidoException();
		}
		
		if(encuesta.getGrupoSegundo().equals("2A")||encuesta.getGrupoSegundo().equals("2B")||encuesta.getGrupoSegundo().equals("2C")
				||encuesta.getGrupoSegundo().equals("2D")||encuesta.getGrupoSegundo().isEmpty()) {
			encuestaEntity.setGrupoSegundo(encuesta.getGrupoSegundo());
		}else {
			throw new EncuestaNoValidoException();
		}
		
		if(encuesta.getGrupoTercero().equals("3A")||encuesta.getGrupoTercero().equals("3B")||encuesta.getGrupoTercero().equals("3C")
				||encuesta.getGrupoTercero().isEmpty()) {
			encuestaEntity.setGrupoTercero(encuesta.getGrupoTercero());
		}else {
			throw new EncuestaNoValidoException();
		}
		
		if(encuesta.getGrupoCuarto().equals("4A")||encuesta.getGrupoCuarto().isEmpty()) {
			encuestaEntity.setGrupoCuarto(encuesta.getGrupoCuarto());
		}else {
			throw new EncuestaNoValidoException();
		}
		em.persist(encuestaEntity);
	}


	@Override
	public void actualizarEncuesta(Encuesta encuesta,EncuestaId encuestaId) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaId);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		if(encuesta.getGrupoPrimero().equals("1A")||encuesta.getGrupoPrimero().equals("1B")||encuesta.getGrupoPrimero().equals("1C")||encuesta.getGrupoPrimero().equals("1D")
					||encuesta.getGrupoPrimero().equals("1E")||encuesta.getGrupoPrimero().isEmpty()){
			encuestaEntity.setGrupoPrimero(encuesta.getGrupoPrimero());
		}else {
			throw new EncuestaNoEncontradaException();
		}
		
		if(encuesta.getGrupoSegundo().equals("2A")||encuesta.getGrupoSegundo().equals("2B")||encuesta.getGrupoSegundo().equals("2C")
				||encuesta.getGrupoSegundo().equals("2D")||encuesta.getGrupoSegundo().isEmpty()) {
			encuestaEntity.setGrupoSegundo(encuesta.getGrupoSegundo());
		}else {
			throw new EncuestaNoEncontradaException();
		}
		
		if(encuesta.getGrupoTercero().equals("3A")||encuesta.getGrupoTercero().equals("3B")||encuesta.getGrupoTercero().equals("3C")
				||encuesta.getGrupoTercero().isEmpty()) {
			encuestaEntity.setGrupoTercero(encuesta.getGrupoTercero());
		}else {
			throw new EncuestaNoEncontradaException();
		}
		
		if(encuesta.getGrupoCuarto().equals("4A")||encuesta.getGrupoCuarto().isEmpty()) {
			encuestaEntity.setGrupoCuarto(encuesta.getGrupoCuarto());
		}else {
			throw new EncuestaNoEncontradaException();
		}
		em.persist(encuestaEntity);
	}


	@Override
	public void borrarEncuesta(EncuestaId encuestaId) throws EncuestaNoEncontradaException {
		Encuesta encuestaEntity = em.find(Encuesta.class, encuestaId);
		
		if(encuestaEntity == null) {
			throw new EncuestaNoEncontradaException();
		}
		
		em.remove(encuestaEntity);
	};
}
