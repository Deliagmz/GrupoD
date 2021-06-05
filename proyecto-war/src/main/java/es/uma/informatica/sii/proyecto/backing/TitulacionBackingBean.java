package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionTitulacion;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Titulacion;

@Named(value="titulacion")
@RequestScoped
public class TitulacionBackingBean {
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionTitulacion gestionT;
	
	private Titulacion titulacion = new Titulacion();
	
	private Integer codigo;
	private String nombre;
	private Integer creditos;
	
	public TitulacionBackingBean(){
	
	}
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

}
