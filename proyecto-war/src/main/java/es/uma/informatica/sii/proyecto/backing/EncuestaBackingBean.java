package es.uma.informatica.sii.proyecto.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionEncuestaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;
import es.uma.informatica.jpa.proyecto.Encuesta.EncuestaId;

@Named(value="encuesta")
@RequestScoped
public class EncuestaBackingBean {
	
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionEncuestaEJB gestionE;
	
	private Encuesta encuesta;
	private EncuestaId encuestaId;

	
	public EncuestaBackingBean(){
		encuesta = new Encuesta();
		encuestaId = new EncuestaId();
		
	}
	
	public String crearEncuesta() {
		try {
			gestionE.crearEncuesta(this.encuesta, this.encuestaId);
		}catch(SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}
	
	public void leerEncuesta() {
		try {
			encuesta = gestionE.leerEncuesta(this.encuestaId);
		
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	public String borrarEncuesta() {
		try {
			gestionE.borrarEncuesta(this.encuestaId);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}
	
	public String actualizarEncuesta() {
		try {
			gestionE.actualizarEncuesta(this.encuesta,this.encuestaId);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
			
	}
	
	public String encuestaString() {
		return encuesta.toString();
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public EncuestaId getEncuestaId() {
		return encuestaId;
	}

	public void setEncuestaId(EncuestaId encuestaId) {
		this.encuestaId = encuestaId;
	}
	
	
}