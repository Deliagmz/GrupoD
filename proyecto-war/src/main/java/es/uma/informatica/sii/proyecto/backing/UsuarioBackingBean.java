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
	
	public Usuario actualizarUsuario (String email, String telefono, String direccion, String dni) {
		
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
		
		return usuario;
		
	}
	
	public void borrarUsuario (String dni) {
		try {
			gestionU.eliminarUsuario(dni);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
