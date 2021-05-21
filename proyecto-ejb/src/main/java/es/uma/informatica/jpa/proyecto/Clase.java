package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity

@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	
	public static class ClaseId implements Serializable{
		private String grupos;
		private String Dia;         
		private String Hora_inicio;
	}
	
	
	   
	@Id
	private String Dia;   
	@Id
	private String Hora_inicio;
	private String Hora_fin;
	private static final long serialVersionUID = 1L;
	

	
	
//Relacion con Asignaturas
	@ManyToOne
	private Asignaturas asignatura;
	
//Relacion con Grupo
		@Id
		@ManyToOne
		private Grupo grupos;
	
	public Clase() {
		super();
	}   
	public String getDia() {
		return this.Dia;
	}

	public void setDia(String Dia) {
		this.Dia = Dia;
	}   
	public String getHora_inicio() {
		return this.Hora_inicio;
	}

	public void setHora_inicio(String Hora_inicio) {
		this.Hora_inicio = Hora_inicio;
	}   
	public String getHora_fin() {
		return this.Hora_fin;
	}

	public void setHora_fin(String Hora_fin) {
		this.Hora_fin = Hora_fin;
	}
	@Override
	public String toString() {
		return "Clase [Dia=" + Dia + ", Hora_inicio=" + Hora_inicio + ", Hora_fin=" + Hora_fin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((Hora_fin == null) ? 0 : Hora_fin.hashCode());
		result = prime * result + ((Hora_inicio == null) ? 0 : Hora_inicio.hashCode());
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
		Clase other = (Clase) obj;
		if (Dia == null) {
			if (other.Dia != null)
				return false;
		} else if (!Dia.equals(other.Dia))
			return false;
		if (Hora_fin == null) {
			if (other.Hora_fin != null)
				return false;
		} else if (!Hora_fin.equals(other.Hora_fin))
			return false;
		if (Hora_inicio == null) {
			if (other.Hora_inicio != null)
				return false;
		} else if (!Hora_inicio.equals(other.Hora_inicio))
			return false;
		return true;
	}
   
}
