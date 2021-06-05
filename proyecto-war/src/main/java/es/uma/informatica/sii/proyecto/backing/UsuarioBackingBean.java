package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionUsuario;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Usuario;

@Named(value="usuario")
@RequestScoped
public class UsuarioBackingBean {
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionUsuario gestionU;
	
	private Usuario usuario;
	private String dni;
	private String email;
	private String telefono;
	private String direccion;
	private String nombre;
	private String apellido;
	private String contrasena;
	
	public UsuarioBackingBean(){
		
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Usuario leerUsuario(String dni)  {
		
		try {
			usuario = gestionU.obtenerUsuario(dni);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public String actualizarUsuario (String email, String telefono, String direccion, String dni) {
		
		try {
			usuario = gestionU.obtenerUsuario(dni);
			//gestionU.actualizarUsuario(email, telefono, direccion,dni);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			usuario.setDireccion(direccion);
			
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "indexSecretaria.xhtml";
		
	}
	
	public String borrarUsuario (String dni) {
		try {
			gestionU.eliminarUsuario(dni);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
