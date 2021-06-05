package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.proyecto.GestionExpedientes;
import es.uma.informatica.ejb.proyecto.GestionMatricula;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Expedientes;
import es.uma.informatica.jpa.proyecto.Matricula;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;
import es.uma.informatica.jpa.proyecto.Matricula.MatriculaId;

@Named(value="expediente")
@RequestScoped
public class ExpedienteBackingBean {
	@Inject
	private InfoSesion infosesion;
	
	@Inject
	GestionExpedientes gestionE;

    @Inject
	GestionMatricula gestionM;
	
	private Expedientes expediente;
    private Matricula matricula;
    
	private double notaMedia;
	
	public ExpedienteBackingBean(){
		
	}
	
	public Expedientes getExpediente() {
		return expediente;
	}
	
    public Matricula getMatricula(){
        return matricula;
    }
//?????????????????????????????????????????????????????????????????????//
    public Matricula obtenerMatricula(MatriculaId matriculaId){
        try {
			matricula = gestionM.obtenerMatricula(matriculaId);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matricula;
    }


	public Double leerNotaMedia(Long Num_Expediente)  {
		try {
		 notaMedia = gestionE.leerNotaMedia(Num_Expediente);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notaMedia;
	}
	
	public void cambiarNotaMedia(Long Num_Expediente, Double Nota_media) {
		
		try {
			gestionE.cambiarNotaMedia(Num_Expediente,Nota_media);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void borrarNotaMedia(Long Num_Expediente) {
		try {
			gestionE.borrarNotaMedia(Num_Expediente);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}