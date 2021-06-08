package es.uma.informatica.ejb.proyecto;

import java.sql.Timestamp;

import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.proyecto.excepciones.EncuestaNoValidoException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;

@Local
public interface GestionEncuestaEJB {

	void actualizarEncuesta(Encuesta encuesta, EncuestaId encuestaId) throws EncuestaNoEncontradaException;

	void borrarEncuesta(EncuestaId encuestaId) throws EncuestaNoEncontradaException;

	public Encuesta leerEncuesta(EncuestaId encuestaId) throws EncuestaNoEncontradaException;

	void crearEncuesta(Encuesta encuesta,EncuestaId encuestaId) throws EncuestaNoValidoException;

}
