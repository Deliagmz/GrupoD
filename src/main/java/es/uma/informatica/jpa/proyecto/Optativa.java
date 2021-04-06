package es.uma.informatica.jpa.proyecto;

import es.uma.informatica.jpa.proyecto.Asignaturas;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

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
