package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Centro
 *
 */
@Entity

public class Centro implements Serializable {

	   
	@Id @Column(length = 52)
	private String ID;
	@Column(nullable = false, length = 52, unique = true)
	private String Nombre;
	@Column(nullable = false, length = 52)
	private String Direccion;
	private Integer TLF_Conserjeria;
	private static final long serialVersionUID = 1L;

	//Lista para la relación con Titulación
	@ManyToMany
	@JoinTable(name = "jn_tit_cntr", joinColumns = @JoinColumn(name = "centro_fk"), 
				inverseJoinColumns = @JoinColumn(name = "tit_fk"))
	private List<Titulacion> titulacion;	
	
	public Centro() {
		super();
	}   
	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public Integer getTLF_ConserjerÃ­a() {
		return this.TLF_Conserjeria;
	}

	public void setTLF_ConserjerÃ­a(Integer TLF_ConserjerÃ­a) {
		this.TLF_Conserjeria = TLF_ConserjerÃ­a;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((TLF_Conserjeria == null) ? 0 : TLF_Conserjeria.hashCode());
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
		Centro other = (Centro) obj;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (TLF_Conserjeria == null) {
			if (other.TLF_Conserjeria != null)
				return false;
		} else if (!TLF_Conserjeria.equals(other.TLF_Conserjeria))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [ID=" + ID + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", TLF_Conserjeria="
				+ TLF_Conserjeria + "]";
	}
	
	
   
}
