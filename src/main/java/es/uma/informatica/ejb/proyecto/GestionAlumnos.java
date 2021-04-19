package es.uma.informatica.ejb.proyecto;


public interface GestionAlumnos {
	
	
	public Alumno LecturaAlumno(Long Id) throws SecretariaException;

	public void ActualizarAlumno(Long Id, Alumno alumno)throws SecretariaException;
	
	public void EliminarAlumno(Long Id,Alumno alumno)throws SecretariaException;
}