package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GRUPOS_POR_ASIGNATURA
 *
 */
@Entity

public class Gupos_Por_Asignatura implements Serializable {

	   
	@Id
	@Column( nullable = false, length = 52)
	private String Curso_Academico;
	private Boolean Oferta;
	private static final long serialVersionUID = 1L;

	public Gupos_Por_Asignatura() {
		super();
	}   
	public String getCurso_Academico() {
		return this.Curso_Academico;
	}

	public void setCurso_Academico(String Curso_Academico) {
		this.Curso_Academico = Curso_Academico;
	}   
	public Boolean getOferta() {
		return this.Oferta;
	}

	public void setOferta(Boolean Oferta) {
		this.Oferta = Oferta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((Oferta == null) ? 0 : Oferta.hashCode());
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
		Gupos_Por_Asignatura other = (Gupos_Por_Asignatura) obj;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Oferta == null) {
			if (other.Oferta != null)
				return false;
		} else if (!Oferta.equals(other.Oferta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GRUPOS_POR_ASIGNATURA [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta + "]";
	}
   
}
