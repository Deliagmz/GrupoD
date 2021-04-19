package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Titulacion implements Serializable {

	   
	@Id
	private Integer Codigo;
	@Column( nullable = false)
	private Integer Creditos;
	@Column( nullable = false, length = 52)
	private String Nombre;
	private static final long serialVersionUID = 1L;

	//Relacion con Optativa
		@ManyToMany (mappedBy="titulaciones")
		private List<Optativa> optativa;
		
	//Relacion titulacion y expediente
	@OneToMany (mappedBy="titulacion")
	private List<Expedientes> expedientes;

	//Relacion titulacion y asignaturas
	@OneToMany (mappedBy="titulacion")
	private List<Asignaturas> asignaturas;

	//Relacion titulacion y grupo
	@OneToMany (mappedBy="titulacion")
	private List<Grupo> grupos;
	
	//Relacion titulacion y centro
	@ManyToMany(mappedBy="titulacion")
	private List<Centro> centros;
	
	
	public Titulacion() {
		super();
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + Codigo + ", Creditos=" + Creditos + ", Nombre=" + Nombre + "]";
	}
	
   
}
