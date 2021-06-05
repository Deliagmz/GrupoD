package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {
	
	public static class MatriculaId implements Serializable{
		private String Curso_academico;
		private Long expedientes;
		
//		public MatriculaId (String Cursoacademico,Long expedientes) {
//			this.Curso_academico = Cursoacademico;
//			this.expedientes=expedientes;
//		}

		public String getCurso_academico() {
			return Curso_academico;
		}

		public void setCurso_academico(String curso_academico) {
			Curso_academico = curso_academico;
		}

		public Long getExpedientes() {
			return expedientes;
		}

		public void setExpedientes(Long expedientes) {
			this.expedientes = expedientes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
			result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
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
			MatriculaId other = (MatriculaId) obj;
			if (Curso_academico == null) {
				if (other.Curso_academico != null)
					return false;
			} else if (!Curso_academico.equals(other.Curso_academico))
				return false;
			if (expedientes == null) {
				if (other.expedientes != null)
					return false;
			} else if (!expedientes.equals(other.expedientes))
				return false;
			return true;
		}
		
		
	}
	   
	@Id
	private String Curso_academico;
	@Column( nullable = false, length = 20)
	private String Estado;
	private Integer Num_Archivo;
	private String Turno_Preferente;
	@Column( nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_de_matricula;
	private Boolean Nuevo_ingreso;

////Relacion muchos a muchos con Asignaturas
//	@JoinTable(name = "Asignaturas_Matricula",
//			joinColumns = @JoinColumn(name= "matricula_fk"),
//			inverseJoinColumns = @JoinColumn(name="asignatura_fk"))
//	private List<Asignaturas> Listado_Asignaturas;
	
	@OneToMany(mappedBy="matricula")
	private List<Asignaturas_Matricula> asignaturas_matricula;
	
	
	
	@Id
	@ManyToOne
	private Expedientes expedientes;
	
	private static final long serialVersionUID = 1L;
	
	

	public Matricula() {
		super();
	}   
	public String getCurso_academico() {
		return this.Curso_academico;
	}

	public void setCurso_academico(String Curso_academico) {
		this.Curso_academico = Curso_academico;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}   
	public Integer getNum_Archivo() {
		return this.Num_Archivo;
	}

	public void setNum_Archivo(Integer Num_Archivo) {
		this.Num_Archivo = Num_Archivo;
	}   
	public String getTurno_Preferente() {
		return this.Turno_Preferente;
	}

	public void setTurno_Preferente(String Turno_Preferente) {
		this.Turno_Preferente = Turno_Preferente;
	}   
	public Date getFecha_de_matricula() {
		return this.Fecha_de_matricula;
	}

	public void setFecha_de_matricula(Date Fecha_de_matricula) {
		this.Fecha_de_matricula = Fecha_de_matricula;
	}   
	public Boolean getNuevo_ingreso() {
		return this.Nuevo_ingreso;
	}

	public void setNuevo_ingreso(Boolean Nuevo_ingreso) {
		this.Nuevo_ingreso = Nuevo_ingreso;
	}   
	
	public Expedientes getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(Expedientes expedientes) {
		this.expedientes = expedientes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_de_matricula == null) ? 0 : Fecha_de_matricula.hashCode());
//		result = prime * result + ((Listado_Asignaturas == null) ? 0 : Listado_Asignaturas.hashCode());
		result = prime * result + ((Nuevo_ingreso == null) ? 0 : Nuevo_ingreso.hashCode());
		result = prime * result + ((Num_Archivo == null) ? 0 : Num_Archivo.hashCode());
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
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
		Matricula other = (Matricula) obj;
		if (Curso_academico == null) {
			if (other.Curso_academico != null)
				return false;
		} else if (!Curso_academico.equals(other.Curso_academico))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_de_matricula == null) {
			if (other.Fecha_de_matricula != null)
				return false;
		} else if (!Fecha_de_matricula.equals(other.Fecha_de_matricula))
			return false;
//		if (Listado_Asignaturas == null) {
//			if (other.Listado_Asignaturas != null)
//				return false;
//		} else if (!Listado_Asignaturas.equals(other.Listado_Asignaturas))
//			return false;
		if (Nuevo_ingreso == null) {
			if (other.Nuevo_ingreso != null)
				return false;
		} else if (!Nuevo_ingreso.equals(other.Nuevo_ingreso))
			return false;
		if (Num_Archivo == null) {
			if (other.Num_Archivo != null)
				return false;
		} else if (!Num_Archivo.equals(other.Num_Archivo))
			return false;
		if (Turno_Preferente == null) {
			if (other.Turno_Preferente != null)
				return false;
		} else if (!Turno_Preferente.equals(other.Turno_Preferente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Matricula [Curso_academico=" + Curso_academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Fecha_de_matricula=" + Fecha_de_matricula
				+ ", Nuevo_ingreso=" + Nuevo_ingreso +  "]";
	}
   
}
