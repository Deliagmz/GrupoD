package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {

	@EmbeddedId
	private EncuestaPK clave_encuestaPK;
	
	@JoinColumn(name="NUM_EXPEDIENTE",referencedColumnName="NUM_EXPEDIENTE")
	@ManyToOne
	private Expedientes expedientes

	public Encuesta() {
		super();
	}

	public EncuestaPK getClave_encuestaPK() {
		return clave_encuestaPK;
	}

	public void setClave_encuestaPK(EncuestaPK clave_encuestaPK) {
		this.clave_encuestaPK = clave_encuestaPK;
	}

	public Expedientes getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(Expedientes expedientes) {
		this.expedientes = expedientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave_encuestaPK == null) ? 0 : clave_encuestaPK.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (clave_encuestaPK == null) {
			if (other.clave_encuestaPK != null)
				return false;
		} else if (!clave_encuestaPK.equals(other.clave_encuestaPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [clave_encuestaPK=" + clave_encuestaPK + "]";
	}   
	
   
}
