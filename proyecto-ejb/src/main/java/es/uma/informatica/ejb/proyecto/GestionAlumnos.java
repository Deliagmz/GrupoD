package es.uma.informatica.ejb.proyecto;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Alumno;
import es.uma.informatica.jpa.proyecto.Usuario;

public interface GestionAlumnos {
	
	
	public Alumno LecturaAlumno(Long Id) throws SecretariaException;

	public void ActualizarAlumno(Long Id, Alumno alumno)throws SecretariaException;
	
	public void EliminarAlumno(Long id)throws SecretariaException;
	
	
    
}