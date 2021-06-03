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
	
	private Titulacion titulacion;
	
	public TitulacionBackingBean(){
		
	}
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	
	public Titulacion leerTitulacion(Integer codigo)  {
		
		try {
			titulacion = gestionT.obtenerTitulacion(codigo);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return titulacion;
	}
	
	public Titulacion actualizarTitulacion (Integer codigo, Integer ncodigo, String nnombre, Integer ncreditos) {
		
		try {
			titulacion = gestionT.obtenerTitulacion(codigo);
			titulacion.setCodigo(ncodigo);
			titulacion.setNombre(nnombre);
			titulacion.setCreditos(ncreditos);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return titulacion;
		
	}
	
	public void borrarTitulacion (Integer codigo) {
		try {
			gestionT.eliminarTitulacion(codigo);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
