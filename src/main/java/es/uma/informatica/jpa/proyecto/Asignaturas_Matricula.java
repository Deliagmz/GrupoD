package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignaturas_Matricula
 *
 */
@Entity

public class Asignaturas_Matricula implements Serializable {
	
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Curso",nullable=false, referencedColumnName="Curso")
	private Matricula matricula;
	
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ref",nullable = false, referencedColumnName = "ref")
	private Asignaturas asignatura;
	
	private static final long serialVersionUID = 1L;

	public Asignaturas_Matricula() {
		super();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Asignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignaturas_Matricula other = (Asignaturas_Matricula) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas_Matricula [matricula=" + matricula + ", asignatura=" + asignatura + "]";
	}
	
	
   
}
