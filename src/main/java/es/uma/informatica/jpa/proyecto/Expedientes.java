package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Expedientes
 *
 */
@Entity

public class Expedientes implements Serializable {

	   
	@Id
	private Long Num_Expediente;
	private Boolean Activo;
	private Double Nota_Media_Provisional;
	private	Double Creditos_superados;
	private	Double Creditos_FB;
	private	Double Creditos_OB;
	private	Double Creditos_OP;
	private	Double Creditos_CF;
	private	Double Creditos_PE;
	private	Double Creditos_TF;
	
	
//Relacion con Matricula
	@OneToMany(mappedBy = "expedientes")
	private List<Matricula>matriculas;
	
//Relacion con Encuesta
	@OneToMany(mappedBy = "expediente")
	private List<Encuesta>encuestas;

//Relacion con Alumno
	@ManyToOne
	private Alumno alumno;
	
//Relacion con Titulacion
	@ManyToOne
	private Titulacion titulacion;
	
	private static final long serialVersionUID = 1L;

	public Expedientes() {
		super();
	}   
	public Long getNum_Expediente() {
		return this.Num_Expediente;
	}

	public void setNum_Expediente(Long Num_Expediente) {
		this.Num_Expediente = Num_Expediente;
	}   
	public Boolean getActivo() {
		return this.Activo;
	}

	public void setActivo(Boolean Activo) {
		this.Activo = Activo;
	}   
	public Double getNota_Media_Provisional() {
		return this.Nota_Media_Provisional;
	}

	public void setNota_Media_Provisional(Double Nota_Media_Provisional) {
		this.Nota_Media_Provisional = Nota_Media_Provisional;
	}
	
	public List<Encuesta> getEncuestas() {
		return encuestas;
	}
	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}
	public Double getCreditos_superados() {
		return Creditos_superados;
	}
	public void setCreditos_superados(Double creditos_superados) {
		Creditos_superados = creditos_superados;
	}
	public Double getCreditos_FB() {
		return Creditos_FB;
	}
	public void setCreditos_FB(Double creditos_FB) {
		Creditos_FB = creditos_FB;
	}
	public Double getCreditos_OB() {
		return Creditos_OB;
	}
	public void setCreditos_OB(Double creditos_OB) {
		Creditos_OB = creditos_OB;
	}
	public Double getCreditos_OP() {
		return Creditos_OP;
	}
	public void setCreditos_OP(Double creditos_OP) {
		Creditos_OP = creditos_OP;
	}
	public Double getCreditos_CF() {
		return Creditos_CF;
	}
	public void setCreditos_CF(Double creditos_CF) {
		Creditos_CF = creditos_CF;
	}
	public Double getCreditos_PE() {
		return Creditos_PE;
	}
	public void setCreditos_PE(Double creditos_PE) {
		Creditos_PE = creditos_PE;
	}
	public Double getCreditos_TF() {
		return Creditos_TF;
	}
	public void setCreditos_TF(Double creditos_TF) {
		Creditos_TF = creditos_TF;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((Creditos_CF == null) ? 0 : Creditos_CF.hashCode());
		result = prime * result + ((Creditos_FB == null) ? 0 : Creditos_FB.hashCode());
		result = prime * result + ((Creditos_OB == null) ? 0 : Creditos_OB.hashCode());
		result = prime * result + ((Creditos_OP == null) ? 0 : Creditos_OP.hashCode());
		result = prime * result + ((Creditos_PE == null) ? 0 : Creditos_PE.hashCode());
		result = prime * result + ((Creditos_TF == null) ? 0 : Creditos_TF.hashCode());
		result = prime * result + ((Creditos_superados == null) ? 0 : Creditos_superados.hashCode());
		result = prime * result + ((Nota_Media_Provisional == null) ? 0 : Nota_Media_Provisional.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expedientes other = (Expedientes) obj;
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (Creditos_CF == null) {
			if (other.Creditos_CF != null)
				return false;
		} else if (!Creditos_CF.equals(other.Creditos_CF))
			return false;
		if (Creditos_FB == null) {
			if (other.Creditos_FB != null)
				return false;
		} else if (!Creditos_FB.equals(other.Creditos_FB))
			return false;
		if (Creditos_OB == null) {
			if (other.Creditos_OB != null)
				return false;
		} else if (!Creditos_OB.equals(other.Creditos_OB))
			return false;
		if (Creditos_OP == null) {
			if (other.Creditos_OP != null)
				return false;
		} else if (!Creditos_OP.equals(other.Creditos_OP))
			return false;
		if (Creditos_PE == null) {
			if (other.Creditos_PE != null)
				return false;
		} else if (!Creditos_PE.equals(other.Creditos_PE))
			return false;
		if (Creditos_TF == null) {
			if (other.Creditos_TF != null)
				return false;
		} else if (!Creditos_TF.equals(other.Creditos_TF))
			return false;
		if (Creditos_superados == null) {
			if (other.Creditos_superados != null)
				return false;
		} else if (!Creditos_superados.equals(other.Creditos_superados))
			return false;
		if (Nota_Media_Provisional == null) {
			if (other.Nota_Media_Provisional != null)
				return false;
		} else if (!Nota_Media_Provisional.equals(other.Nota_Media_Provisional))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Expedientes [Num_Expediente=" + Num_Expediente + ", Activo=" + Activo + ", Nota_Media_Provisional="
				+ Nota_Media_Provisional + ", Creditos_superados=" + Creditos_superados + ", Creditos_FB=" + Creditos_FB
				+ ", Creditos_OB=" + Creditos_OB + ", Creditos_OP=" + Creditos_OP + ", Creditos_CF=" + Creditos_CF
				+ ", Creditos_PE=" + Creditos_PE + ", Creditos_TF=" + Creditos_TF + "]";
	}
   
}
