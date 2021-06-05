package es.uma.informatica.ejb.proyecto;
import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Titulacion;



@Local
public interface GestionTitulacion {
	
	public Titulacion obtenerTitulacion(Integer codigo) throws SecretariaException;
	
	public void eliminarTitulacion(Integer codigo) throws SecretariaException;
	
	public void actualizarTitulacion(Integer codigo,String nombre, Integer creditos) throws SecretariaException;
	
}
