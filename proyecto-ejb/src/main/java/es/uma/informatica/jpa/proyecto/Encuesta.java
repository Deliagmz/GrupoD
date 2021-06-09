package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity
@IdClass(Encuesta.EncuestaId.class)
public class Encuesta implements Serializable {
	
	public static class EncuestaId implements Serializable{
		
		private String fecha_de_envio;
		private Long expediente;
		public EncuestaId(String t, Long nExp) {
			fecha_de_envio = t;
			expediente = nExp;
		}
		public EncuestaId() {
			this.fecha_de_envio = fecha_de_envio;
			this.expediente = expediente;
		}
		public String getFecha_de_envio() {
			return fecha_de_envio;
		}
		public void setFecha_de_envio(String fecha_de_envio) {
			this.fecha_de_envio = fecha_de_envio;
		}
		public Long getExpediente() {
			return expediente;
		}
		public void setExpediente(Long expediente) {
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
			EncuestaId other = (EncuestaId) obj;
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
		
		
		
	}

	@Id
	private String fecha_de_envio;
	private String grupoPrimero;
	private String grupoSegundo;
	private String grupoTercero;
	private String grupoCuarto;
	
	//relacion para hacer entidad debil
	@Id
	@ManyToOne
	private Expedientes expediente;
	
	//relacion con grpXasig
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "jn_enc_grpXasi")
	private List<Grupos_Por_Asignatura> gr_asignaturas;
   
	
	public Encuesta() {
		super();
	}
	


	public String getFecha_de_envio() {
		return fecha_de_envio;
	}

	public void setFecha_de_envio(String t) {
		this.fecha_de_envio = t;
	}

	public Expedientes getExpediente() {
		return expediente;
	}

	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}



	public String getGrupoPrimero() {
		return grupoPrimero;
	}



	public void setGrupoPrimero(String grupoPrimero) {
		this.grupoPrimero = grupoPrimero;
	}



	public String getGrupoSegundo() {
		return grupoSegundo;
	}



	public void setGrupoSegundo(String grupoSegundo) {
		this.grupoSegundo = grupoSegundo;
	}



	public String getGrupoTercero() {
		return grupoTercero;
	}



	public void setGrupoTercero(String grupoTercero) {
		this.grupoTercero = grupoTercero;
	}



	public String getGrupoCuarto() {
		return grupoCuarto;
	}



	public void setGrupoCuarto(String grupoCuarto) {
		this.grupoCuarto = grupoCuarto;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((fecha_de_envio == null) ? 0 : fecha_de_envio.hashCode());
		result = prime * result + ((gr_asignaturas == null) ? 0 : gr_asignaturas.hashCode());
		result = prime * result + ((grupoCuarto == null) ? 0 : grupoCuarto.hashCode());
		result = prime * result + ((grupoPrimero == null) ? 0 : grupoPrimero.hashCode());
		result = prime * result + ((grupoSegundo == null) ? 0 : grupoSegundo.hashCode());
		result = prime * result + ((grupoTercero == null) ? 0 : grupoTercero.hashCode());
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
		if (gr_asignaturas == null) {
			if (other.gr_asignaturas != null)
				return false;
		} else if (!gr_asignaturas.equals(other.gr_asignaturas))
			return false;
		if (grupoCuarto == null) {
			if (other.grupoCuarto != null)
				return false;
		} else if (!grupoCuarto.equals(other.grupoCuarto))
			return false;
		if (grupoPrimero == null) {
			if (other.grupoPrimero != null)
				return false;
		} else if (!grupoPrimero.equals(other.grupoPrimero))
			return false;
		if (grupoSegundo == null) {
			if (other.grupoSegundo != null)
				return false;
		} else if (!grupoSegundo.equals(other.grupoSegundo))
			return false;
		if (grupoTercero == null) {
			if (other.grupoTercero != null)
				return false;
		} else if (!grupoTercero.equals(other.grupoTercero))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Encuesta fecha_de_envio=" + fecha_de_envio + ", grupoPrimero=" + grupoPrimero + ", grupoSegundo="
				+ grupoSegundo + ", grupoTercero=" + grupoTercero + ", grupoCuarto=" + grupoCuarto + ", expediente="
				+ expediente ;
	}
	
	
	
	
   
}
