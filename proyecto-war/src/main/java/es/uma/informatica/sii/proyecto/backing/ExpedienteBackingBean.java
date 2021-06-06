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
    private MatriculaId matriculaId;
    
    

	private Double notaMedia;
//	private Long numExpediente;
//	private String cursoAcademico;
	
	
	public ExpedienteBackingBean(){
		expediente=new Expedientes();
	}


		public Expedientes getExpediente() {
			
			return expediente;
		}
		

		public Matricula getMatricula() {
			return matricula;
		}


		public void setMatricula(Matricula matricula) {
			this.matricula = matricula;
		}


		public Double getNotaMedia() {
			return notaMedia;
		}


		public void setNotaMedia(Double notaMedia) {
			this.notaMedia = notaMedia;
		}


	//?????????????????????????????????????????????????????????????????????//
    public void obtenerMatricula(){
        try {
        	//this.getMatricula().setCurso_academico(this.getExpediente().ge);
//        	this.getMatriculaId().setCurso_academico(this.getMatricula().getCurso_academico());
//        	this.getMatriculaId().setExpedientes(this.getExpediente().getNum_Expediente());
        	matricula = gestionM.obtenerMatricula(this.getMatriculaId());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	public String matriculaString() {
		return this.matricula.toString();
	}

	public String modificar() {
		try {
			gestionE.cambiarNotaMedia(this.expediente.getNum_Expediente(),this.notaMedia);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "indexSecretaria.xhtml";
    }

	public void leerNotaMedia()  {
		try {
		 notaMedia = gestionE.leerNotaMedia(this.expediente.getNum_Expediente());
		 expediente.setNota_Media_Provisional(notaMedia);
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String notaMediaToString() {
		return expediente.notaMediaToString();
	}
	
	public String borrarNotaMedia() {
		try {
			gestionE.borrarNotaMedia(this.expediente.getNum_Expediente());
		} catch (SecretariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "indexSecretaria.xhtml";
	}


	public MatriculaId getMatriculaId() {
		return matriculaId;
	}


	public void setMatriculaId(MatriculaId matriculaId) {
		this.matriculaId = matriculaId;
	}


	


	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}
	
	





	
}
