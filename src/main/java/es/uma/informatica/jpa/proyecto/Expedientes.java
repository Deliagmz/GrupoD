package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expedientes
 *
 */
@Entity

public class Expedientes implements Serializable {

	   
	@Id
	private Long Num_Expediente;
	private Boolean Activo;
	private Double Nota_Media_Provisional;
	private static final long serialVersionUID = 1L;

	public Expedientes() {
		super();
	}   
	public Long getNum_Expediente() {
		return this.Num_Expediente;
	}

	public void setNum_Expediente(Long Num_Expediente) {
		this.Num_Expediente = Num_Expediente;
	}   
	public Boolean getActivo() {
		return this.Activo;
	}

	public void setActivo(Boolean Activo) {
		this.Activo = Activo;
	}   
	public Double getNota_Media_Provisional() {
		return this.Nota_Media_Provisional;
	}

	public void setNota_Media_Provisional(Double Nota_Media_Provisional) {
		this.Nota_Media_Provisional = Nota_Media_Provisional;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((Nota_Media_Provisional == null) ? 0 : Nota_Media_Provisional.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
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
		Expedientes other = (Expedientes) obj;
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (Nota_Media_Provisional == null) {
			if (other.Nota_Media_Provisional != null)
				return false;
		} else if (!Nota_Media_Provisional.equals(other.Nota_Media_Provisional))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expedientes [Num_Expediente=" + Num_Expediente + ", Activo=" + Activo + ", Nota_Media_Provisional="
				+ Nota_Media_Provisional + "]";
	}
   
}
