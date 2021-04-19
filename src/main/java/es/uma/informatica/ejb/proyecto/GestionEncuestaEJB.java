package es.uma.informatica.ejb.proyecto;

import java.sql.Timestamp;

import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;

@Local
public interface GestionEncuestaEJB {
	
	public String leerEncuesta(EncuestaId encuestaID) throws SecretariaException;
	
	public void crearEncuesta(Timestamp f_d_e, Expedientes e) throws SecretariaException;
	
	public void actualizarEncuesta(EncuestaId encuestaID,Timestamp f_d_e, Expedientes e) throws SecretariaException;
	
	public void borrarEncuesta(EncuestaId encuestaID) throws SecretariaException;

}
