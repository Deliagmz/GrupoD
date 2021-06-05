package es.uma.informatica.ejb.proyecto;

import java.sql.Timestamp;

import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;

@Local
public interface GestionEncuestaEJB {
	
	public Encuesta leerEncuesta(Encuesta encuesta) throws SecretariaException;
	
	public void crearEncuesta(Timestamp f_d_e, Expedientes e) throws SecretariaException;
	
	public void actualizarEncuesta(Encuesta encuesta,Timestamp f_d_e, Expedientes e,String grupo, String curso) throws SecretariaException;
	
	public void borrarEncuesta(Encuesta encuesta) throws SecretariaException;

}
