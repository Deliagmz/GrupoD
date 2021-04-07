package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * ID class for entity: Clase
 *
 */ 
public class ClasePK  implements Serializable {   
   
	         
	private String Dia;         
	private String Hora_inicio;
	private static final long serialVersionUID = 1L;

	public ClasePK() {}

	public static class ClaseId implements Serializable{
		private String ID;
		private Grupo grupos;
		private String Dia;         
		private String Hora_inicio;
	}
	//Relacion con Grupo
		@Id
		@ManyToOne
		private List<Grupo> grupos;

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ClasePK)) {
			return false;
		}
		ClasePK other = (ClasePK) o;
		return true
			&& (getDia() == null ? other.getDia() == null : getDia().equals(other.getDia()))
			&& (getHora_inicio() == null ? other.getHora_inicio() == null : getHora_inicio().equals(other.getHora_inicio()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getDia() == null ? 0 : getDia().hashCode());
		result = prime * result + (getHora_inicio() == null ? 0 : getHora_inicio().hashCode());
		return result;
	}
   
   
}
