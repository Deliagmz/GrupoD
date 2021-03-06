package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity

public class Alumno implements Serializable {

	   
	@Id @GeneratedValue 
	private String ID;
	@Column( unique= true, nullable = false, length = 20)
	private String DNI;
	@Column(nullable = false, length = 52)
	private String Nombre;
	@Column( nullable = false, length = 52)
	private String Apellido1;
	@Column(length = 52)
	private String Apellido2;
	@Column( nullable = false, length = 52)
	private String Email_institucional;
	@Column(length = 52)
	private String Email_personal;
	private Integer Telefono;
	private Integer Movil;
	@Column(length = 255)
	private String Direccion;
	private Integer Codigo_postal;
	@Column(length = 255)
	private String Localidad;
	@Column(length = 55)
	private String Provincia;
	private static final long serialVersionUID = 1L;
	
	//Relacion alumno y expediente
	@OneToMany(fetch=FetchType.EAGER, mappedBy="alumno")
	private List<Expedientes> expedientes;
	
	public Alumno() {
		super();
	}   
	
	
	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public Integer getCodigo_postal() {
		return Codigo_postal;
	}



	public void setCodigo_postal(Integer codigo_postal) {
		Codigo_postal = codigo_postal;
	}

	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {

		Localidad = localidad;

		this.Localidad = localidad;

	}


	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
		this.Provincia = provincia;
	}


	public List<Expedientes> getExpedientes() {
		return expedientes;
	}



	public void setExpedientes(List<Expedientes> expedientes) {
		this.expedientes = expedientes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido1() {
		return this.Apellido1;
	}

	public void setApellido1(String Apellido1) {
		this.Apellido1 = Apellido1;
	}   
	public String getApellido2() {
		return this.Apellido2;
	}

	public void setApellido2(String Apellido2) {
		this.Apellido2 = Apellido2;
	}   
	public String getEmail_institucional() {
		return this.Email_institucional;
	}

	public void setEmail_institucional(String Email_institucional) {
		this.Email_institucional = Email_institucional;
	}   
	public String getEmail_personal() {
		return this.Email_personal;
	}

	public void setEmail_personal(String Email_personal) {
		this.Email_personal = Email_personal;
	}   
	public Integer getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
	}   
	public Integer getMovil() {
		return this.Movil;
	}

	public void setMovil(Integer Movil) {
		this.Movil = Movil;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((Codigo_postal == null) ? 0 : Codigo_postal.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((Email_institucional == null) ? 0 : Email_institucional.hashCode());
		result = prime * result + ((Email_personal == null) ? 0 : Email_personal.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Movil == null) ? 0 : Movil.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
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
		Alumno other = (Alumno) obj;
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (Codigo_postal == null) {
			if (other.Codigo_postal != null)
				return false;
		} else if (!Codigo_postal.equals(other.Codigo_postal))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (Email_institucional == null) {
			if (other.Email_institucional != null)
				return false;
		} else if (!Email_institucional.equals(other.Email_institucional))
			return false;
		if (Email_personal == null) {
			if (other.Email_personal != null)
				return false;
		} else if (!Email_personal.equals(other.Email_personal))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Movil == null) {
			if (other.Movil != null)
				return false;
		} else if (!Movil.equals(other.Movil))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;

		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Alumno " + ID + " con DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2="
				+ Apellido2 + ", Email_institucional=" + Email_institucional + ", Email_personal=" + Email_personal
				+ ", Telefono=" + Telefono + ", Movil=" + Movil + ", Direccion=" + Direccion + ", Codigo_postal="

				+ Codigo_postal + ", Localidad=" + Localidad + ", Provincia=" + Provincia ;

	}
	
	
	
   
}