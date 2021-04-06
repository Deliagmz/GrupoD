package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity

@IdClass(ClasePK.class)
public class Clase implements Serializable {

	   
	@Id
	private String Dia;   
	@Id
	private String Hora_inicio;
	private String Hora_fin;
	private static final long serialVersionUID = 1L;

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
   
}
