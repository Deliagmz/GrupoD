package es.uma.informatica.ejb.proyecto;

import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Expedientes;

@Local
public interface GestionExpedientes {
	
	//obtiene un expediente a partir de su identificador
	public Expedientes obtenerExpediente (Long Num_Expediente) throws SecretariaException;
	
	//Lee la nota media de un expediente
	public double leerNotaMedia(Long Num_Expediente) throws SecretariaException;
	
	//Borra la nota media de un expediente
	public void borrarNotaMedia(Long Num_Expediente) throws SecretariaException;
	
	//Cambia la nota media de un expediente
	public void cambiarNotaMedia(Long Num_Expediente, Double Nota_media) throws SecretariaException;
}
