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
   
}