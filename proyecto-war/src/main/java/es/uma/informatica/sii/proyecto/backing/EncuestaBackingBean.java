package es.uma.informatica.sii.proyecto.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionEncuestaEJB;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Encuesta;

@Named(value="Encuesta")
@RequestScoped
public class EncuestaBackingBean {
	
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionEncuestaEJB gestionE;
	
	private Encuesta encuesta;
	private List<String> gruposPrimero;
	private List<String> gruposSegundo;
	private List<String> gruposTercero;
	private List<String> gruposCuarto;

	
	public EncuestaBackingBean(){
		encuesta = new Encuesta();
		
		gruposPrimero.add("1A");
		gruposPrimero.add("1B");
		gruposPrimero.add("1C");
		gruposPrimero.add("1D");
		gruposPrimero.add("1E");
		
		gruposSegundo.add("2A");
		gruposSegundo.add("2B");
		gruposSegundo.add("2C");
		gruposSegundo.add("2D");
		
		gruposTercero.add("3A");
		gruposTercero.add("3B");
		
		gruposCuarto.add("4A");
	}
	
	public void leerEncuesta() {
		try {
			encuesta = gestionE.leerEncuesta(this.encuesta);
		
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public String borrarTitulacion() {
		try {
			gestionE.borrarEncuesta(this.encuesta);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}
	
	public void actualizarTitulacion() {
		try {
			gestionE.actualizarEncuesta(this.encuesta, this.encuesta.getFecha_de_envio(), this.encuesta.getExpediente());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
			
	}
	
	public String getEnc() {
		return this.encuesta.toString();
	}
}
