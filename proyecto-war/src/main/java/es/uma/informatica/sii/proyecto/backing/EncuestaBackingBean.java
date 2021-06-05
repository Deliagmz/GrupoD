package es.uma.informatica.sii.proyecto.backing;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionEncuestaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Expedientes;

@Named(value = "encuesta")
@RequestScoped
public class EncuestaBackingBean {
	
	@Inject
	GestionEncuestaEJB gestionEncuesta;
	
	private Expedientes expediente;
	
	private List<String> cursos;
	private List<String> grupos;
	private Timestamp fecha_de_envio;
	private String curso;
	private String grupo;

	
	
	public void cearEncuesta() {
		try {
			gestionEncuesta.crearEncuesta(fecha_de_envio, expediente);
		}catch(SecretariaException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void actualizarEncuesta() {
		
		try {
			gestionEncuesta.actualizarEncuesta(this.getFecha_de_envio(), this.getExpediente(),this.getCurso(),this.getGrupo());
		}catch(SecretariaException e) {
			e.printStackTrace();
		}
		
	}

	public String getCurso() {
		String seleccion = "";
		switch(curso) {
		case "1": seleccion = "1";break;
		case "2": seleccion = "2"; break;
		case "3": seleccion = "3"; break;
		case "4": seleccion = "4"; break;
		
		}
		
		return seleccion;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		String seleccion = "";
		switch(curso) {
		case "A": seleccion = "A";break;
		case "B": seleccion = "B"; break;
		case "C": seleccion = "C"; break;
		case "D": seleccion = "D"; break;
		
		}
		return seleccion;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Expedientes getExpediente() {
		return expediente;
	}

	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}

	public Timestamp getFecha_de_envio() {
		return fecha_de_envio;
	}

	public void setFecha_de_envio(Timestamp fecha_de_envio) {
		this.fecha_de_envio = fecha_de_envio;
	}
	
	
	
	
	

}
