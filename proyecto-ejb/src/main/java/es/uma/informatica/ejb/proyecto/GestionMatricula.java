package es.uma.informatica.ejb.proyecto;
import javax.ejb.Local;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;


@Local
public interface GestionMatricula {

	public Matricula obtenerMatricula(MatriculaId matriculaId) throws SecretariaException;
	
}
