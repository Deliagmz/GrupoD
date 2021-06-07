package es.uma.informatica.ejb.proyecto;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Alumno;
import es.uma.informatica.jpa.proyecto.Usuario;

public interface GestionAlumnos {
	
	
	public Alumno LecturaAlumno(String string) throws SecretariaException;

	public void ActualizarAlumno(String string, Alumno alumno)throws SecretariaException;
	
	public void EliminarAlumno(String string)throws SecretariaException;
	
	
    
}