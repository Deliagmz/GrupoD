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
   
}
