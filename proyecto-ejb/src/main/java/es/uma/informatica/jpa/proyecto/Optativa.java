package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Optativa
 *
 */
@Entity

public class Optativa extends Asignaturas implements Serializable {

	@Column( nullable = false)
	private Integer Plazas;
	private String Mencion;
	private static final long serialVersionUID = 1L;

	//Relacion con Optativa
	@ManyToMany
	@JoinTable(name = "jn_tit_opt")
	private List<Titulacion> titulaciones;
	
	public Optativa() {
		super();
	}   
	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}
	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}
	public Integer getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Integer Plazas) {
		this.Plazas = Plazas;
	}   
	public String getMencion() {
		return this.Mencion;
	}

	public void setMencion(String Mencion) {
		this.Mencion = Mencion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mencion == null) ? 0 : Mencion.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((titulaciones == null) ? 0 : titulaciones.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativa other = (Optativa) obj;
		if (Mencion == null) {
			if (other.Mencion != null)
				return false;
		} else if (!Mencion.equals(other.Mencion))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (titulaciones == null) {
			if (other.titulaciones != null)
				return false;
		} else if (!titulaciones.equals(other.titulaciones))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Optativa [Plazas=" + Plazas + ", Mencion=" + Mencion + ", titulaciones=" + titulaciones + "]";
	}
	
   
}