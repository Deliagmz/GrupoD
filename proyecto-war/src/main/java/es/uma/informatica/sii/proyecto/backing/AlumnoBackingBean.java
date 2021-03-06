package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionAlumnos;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Alumno;
import es.uma.informatica.jpa.proyecto.Usuario;

@Named(value="alumno")
@RequestScoped
public class AlumnoBackingBean {
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionAlumnos gestionA;
	
	private Alumno alumno; 
	
	private Long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email_institucional;
	private String email_personal;
	private Integer telefono;
	private Integer movil;
	private String direccion;
	private Integer codigo_postal;
	private String localidad;
	private String provincia;
	
	private String contrasena;
	
	public AlumnoBackingBean(){
		alumno = new Alumno();
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail_institucional() {
		return email_institucional;
	}

	public void setEmail_institucional(String email_institucional) {
		this.email_institucional = email_institucional;
	}

	public String getEmail_personal() {
		return email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getMovil() {
		return movil;
	}

	public void setMovil(Integer movil) {
		this.movil = movil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public void leerAlumno()  {
		
		try {
			alumno = gestionA.LecturaAlumno(this.alumno.getID());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String actualizarAlumno () {
		
		try {
			gestionA.ActualizarAlumno(this.alumno.getID(), this.alumno);
			
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
		
	}
	
	public String borrarAlumno () {
		try {
			gestionA.EliminarAlumno(this.alumno.getID());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}
	
	public String toString() {
		return this.alumno.toString();
	}

	
}