package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable {
	@Column(nullable = false, length = 52)
	private String Nombre;
	@Column(nullable = false, length = 52)
	private String Apellido;
	@Column(nullable = false, length = 52)
	@XmlTransient
    @JsonbTransient
	private String Contrasena;
//	@Column(nullable = false, length = 52)
//	@XmlTransient
//    @JsonbTransient
//	private String RepiteContrasena;
	@Column(nullable = false, length = 52)
	private String DNI;
	@Column(nullable = false, length = 52)
	private String Email;
	@Column(nullable = false, length = 52)
	private String telefono;
	@Column(nullable = false, length = 52)
	private String Direccion;
	
//	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
//    @OrderBy ("nombre ASC")
//    private List<Contacto> contactos;
	@Id
	private String cuenta;
	@XmlTransient
	@JsonbTransient
    private String cadenaValidacion;
	
	public String getCadenaValidacion() {
		return cadenaValidacion;
	}
	public void setCadenaValidacion(String cadenaValidacion) {
		this.cadenaValidacion = cadenaValidacion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
//	public String getRepiteContrasena() {
//		return RepiteContrasena;
//	}
//	public void setRepiteContrasena(String repiteContrasena) {
//		RepiteContrasena = repiteContrasena;
//	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + ((Contrasena == null) ? 0 : Contrasena.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
//		result = prime * result + ((RepiteContrasena == null) ? 0 : RepiteContrasena.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Usuario other = (Usuario) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (Contrasena == null) {
			if (other.Contrasena != null)
				return false;
		} else if (!Contrasena.equals(other.Contrasena))
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
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
//		if (RepiteContrasena == null) {
//			if (other.RepiteContrasena != null)
//				return false;
//		} else if (!RepiteContrasena.equals(other.RepiteContrasena))
//			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Contrasena=" + Contrasena
				+  ", DNI=" + DNI + ", Email=" + Email + ", telefono="
				+ telefono + ", Direccion=" + Direccion + "]";
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
	
	

}
