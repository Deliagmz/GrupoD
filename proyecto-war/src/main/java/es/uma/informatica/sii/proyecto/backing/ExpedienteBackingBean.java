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

@Named(value="expediente")
@RequestScoped
public class ExpedienteBackingBean {


	@Inject
	private InfoSesion infosesion;
	
	@Inject
	private GestionExpedientes gestionE;

    @Inject
	private GestionMatricula gestionM;
	
	

	private Expedientes expediente;
    private Matricula matricula;

	private Double notaMedia;
	private Long numExpediente;
	private String cursoAcademico;
	
	
	public ExpedienteBackingBean(){
		expediente=new Expedientes();
	}


		public Expedientes getExpediente() {
			
			return expediente;
		}

//CONSULTAR ????//
		public Double getNotaMedia() {
				return notaMedia;
		}
		public void setNotaMedia(Double notaMedia) {
			this.notaMedia = notaMedia;
		}
		public Long getNumExpediente() {
			return numExpediente;
		}
		public void setNumExpediente(Long numExpediente) {
			this.numExpediente = numExpediente;
		}
		public String getCursoAcademico() {
				return cursoAcademico;
		}
		public void setCursoAcademico(String cursoAcademico) {
			this.cursoAcademico = cursoAcademico;
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

	public String modificar() {
		try {
			gestionE.cambiarNotaMedia(getNumExpediente(),getNotaMedia());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "indexSecretaria.xhtml";
    }

	public String leerNotaMedia()  {
		try {
		 notaMedia = gestionE.leerNotaMedia(getNumExpediente());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notaMedia.toString();
	}
	
	public String notaMediaToString() {
		return leerNotaMedia();
	}
	public String borrarNotaMedia() {
		try {
			gestionE.borrarNotaMedia(getNumExpediente());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}




	
}
