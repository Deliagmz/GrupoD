package es.uma.informatica.ejb.proyecto;

import javax.ejb.Local;

import es.uma.informatica.jpa.proyecto.Asignaturas;
@Local
public interface GestionAsignaturas {
	
	//Obtiene la asignatura asociada al numero de referencia que se pasa como parametro
	public Asignaturas obtenerAsignatura(Integer referencia) throws SecretariaException;
	
	//Actualiza la asignatura en la base de datos
	public void actualizarAsignatura(Integer referencia, Asignaturas asig) throws SecretariaException;
	
	//Elimina una asignatura de la base de datos
	public void eliminarAsignatura(Integer referencia) throws SecretariaException;
}
