package es.uma.informatica.sii.proyecto.backing;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionAsignaturas;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Asignaturas;

@Named(value="asignatura")
@RequestScoped
public class AsignaturaBackingBean {
	
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	private GestionAsignaturas gestionA;

	private Asignaturas asignatura = new Asignaturas();

	private Integer referencia;
	private Integer codigo;
	private Integer creditos;	
	private Boolean ofertada;
	private String nombre;
	private String curso;
	private String caracter;
	private String duracion;
	private String unidadTemporal;
	private String idiomasImparticion;
	
	public AsignaturaBackingBean(){
		
	}

	public Asignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Boolean getOfertada() {
		return ofertada;
	}

	public void setOfertada(Boolean ofertada) {
		this.ofertada = ofertada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getUnidadTemporal() {
		return unidadTemporal;
	}

	public void setUnidadTemporal(String unidadTemporal) {
		this.unidadTemporal = unidadTemporal;
	}

	public String getIdiomasImparticion() {
		return idiomasImparticion;
	}

	public void setIdiomasImparticion(String idiomasImparticion) {
		this.idiomasImparticion = idiomasImparticion;
	}
	
	public void leerAsignatura() {
		try {
			asignatura = gestionA.obtenerAsignatura(this.asignatura.getReferencia());
			
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public String borrarAsignatura() {
		try {
			gestionA.eliminarAsignatura(this.asignatura.getReferencia());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}
	
	public void actualizarAsignatura() {
		try {
			gestionA.actualizarAsignatura(asignatura.getCodigo(),this.asignatura);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
			
	}
	
	public String toString() {
		return asignatura.toString();
		
	}
	
}
