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
		
	}
	
	
	
	
	

}
