package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EncuestaPK
 *
 */
@Embeddable

public class EncuestaPK implements Serializable {

	@Column(nullable = false)
	private Integer num_expediente;
	@Column(nullable = false)
	private Timestamp fecha_envio;
	private static final long serialVersionUID = 1L;

	public EncuestaPK() {
		super();
	}   
	public Integer getNum_expediente() {
		return this.num_expediente;
	}

	public void setNum_expediente(Integer num_expediente) {
		this.num_expediente = num_expediente;
	}   
	public Timestamp getFecha_envio() {
		return this.fecha_envio;
	}

	public void setFecha_envio(Timestamp fecha_envio) {
		this.fecha_envio = fecha_envio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_envio == null) ? 0 : fecha_envio.hashCode());
		result = prime * result + ((num_expediente == null) ? 0 : num_expediente.hashCode());
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
		EncuestaPK other = (EncuestaPK) obj;
		if (fecha_envio == null) {
			if (other.fecha_envio != null)
				return false;
		} else if (!fecha_envio.equals(other.fecha_envio))
			return false;
		if (num_expediente == null) {
			if (other.num_expediente != null)
				return false;
		} else if (!num_expediente.equals(other.num_expediente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EncuestaPK [num_expediente=" + num_expediente + ", fecha_envio=" + fecha_envio + "]";
	}
   
	
}
