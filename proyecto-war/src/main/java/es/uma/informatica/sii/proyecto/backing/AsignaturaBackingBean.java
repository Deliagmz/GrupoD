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

	private Asignaturas asignatura;

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

	public String getIdiomasImparticion() {
		return idiomasImparticion;
	}

	public void setIdiomasImparticion(String idiomasImparticion) {
		this.idiomasImparticion = idiomasImparticion;
	}


	public String modificar() {
		try {
			Asignaturas a = new Asignaturas();
			a.setCaracter(caracter);
			a.setCodigo(codigo);
			a.setCreditos(creditos);
			a.setCurso(curso);
			a.setDuracion(duracion);
			a.setIdiomas_Imparticion(idiomasImparticion);
			a.setNombre(nombre);
			a.setOfertada(ofertada);
			a.setUnidad_Temporal(unidadTemporal);
			a.setReferencia(referencia);
			gestionA.actualizarAsignatura(getReferencia(),a);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "indexSecretaria.xhtml";
    }

	public String leerAsignatura()  {
		try {
		 asignatura = gestionA.obtenerAsignatura(getReferencia());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignatura.toString();
	}
	
	public String notaMediaToString() {
		return leerAsignatura();
	}
	public String borrarAsignaturas() {
		try {
			gestionA.eliminarAsignatura(getReferencia());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}




	
}
