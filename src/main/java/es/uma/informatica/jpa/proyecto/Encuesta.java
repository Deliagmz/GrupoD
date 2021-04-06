package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity
@IdClass(Encuesta.EncuestaId.class)
public class Encuesta implements Serializable {
	
	public static class EncuestaId implements Serializable{
		private Timestamp fecha_de_envio;
		private Long expediente;
	}

	@Id
	private Timestamp fecha_de_envio;
	
	//relacion para hacer entidad debil
	@Id
	@ManyToOne
	private Expedientes expediente;
	
	//Lista para la relación con grupos por asignatura
	private List<Grupos_Por_Asignatura> asignaturas;
	
	public Encuesta() {
		super();
	}

	public Timestamp getFecha_de_envio() {
		return fecha_de_envio;
	}

	public void setFecha_de_envio(Timestamp fecha_de_envio) {
		this.fecha_de_envio = fecha_de_envio;
	}

	public Expedientes getExpediente() {
		return expediente;
	}

	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((fecha_de_envio == null) ? 0 : fecha_de_envio.hashCode());
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
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (fecha_de_envio == null) {
			if (other.fecha_de_envio != null)
				return false;
		} else if (!fecha_de_envio.equals(other.fecha_de_envio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [fecha_de_envio=" + fecha_de_envio + ", expediente=" + expediente + "]";
	}

	
   
}
