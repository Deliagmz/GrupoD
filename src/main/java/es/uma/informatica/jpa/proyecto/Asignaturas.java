package es.uma.informatica.jpa.proyecto;

import java.awt.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Asignaturas
 *
 */
@Entity

public class Asignaturas implements Serializable {

	   
	@Id
	private Integer Referencia;
	@Column( nullable = false)
	private Integer Codigo;
	@Column( nullable = false)
	private Integer Creditos;
	@Column( nullable = false)
	private boolean Ofertada;
	@Column( nullable = false)
	private String Nombre;
	private String Curso;
	private String Caracter;
	private String Duracion;
	private String Unidad_Temporal;
	private String Idiomas_Imparticion;

//Relacion con Asignaturas_Matricula
	@ManyToMany(mappedBy="Listado_Asignaturas")
	private List<Matricula> lista_matriculas;
	private static final long serialVersionUID = 1L;

	public Asignaturas() {
		super();
	}   
	public Integer getReferencia() {
		return this.Referencia;
	}

	public void setReferencia(Integer Referencia) {
		this.Referencia = Referencia;
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}   
	public boolean getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(boolean Ofertada) {
		this.Ofertada = Ofertada;
	}   
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCurso() {
		return this.Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}   
	public String getCaracter() {
		return this.Caracter;
	}

	public void setCaracter(String Caracter) {
		this.Caracter = Caracter;
	}   
	public String getDuracion() {
		return this.Duracion;
	}

	public void setDuracion(String Duracion) {
		this.Duracion = Duracion;
	}   
	public String getUnidad_Temporal() {
		return this.Unidad_Temporal;
	}

	public void setUnidad_Temporal(String Unidad_Temporal) {
		this.Unidad_Temporal = Unidad_Temporal;
	}   
	public String getIdiomas_Imparticion() {
		return this.Idiomas_Imparticion;
	}

	public void setIdiomas_Imparticion(String Idiomas_Imparticion) {
		this.Idiomas_Imparticion = Idiomas_Imparticion;
	}
	
	@Override
	public String toString() {
		return "Asignaturas [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Creditos=" + Creditos + ", Ofertada="
				+ Ofertada + ", Curso=" + Curso + ", Caracter=" + Caracter + ", Duracion=" + Duracion
				+ ", Unidad_Temporal=" + Unidad_Temporal + ", Idiomas_Imparticion=" + Idiomas_Imparticion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Caracter == null) ? 0 : Caracter.hashCode());
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Duracion == null) ? 0 : Duracion.hashCode());
		result = prime * result + ((Idiomas_Imparticion == null) ? 0 : Idiomas_Imparticion.hashCode());
		result = prime * result + (Ofertada ? 1231 : 1237);
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		result = prime * result + ((Unidad_Temporal == null) ? 0 : Unidad_Temporal.hashCode());
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
		Asignaturas other = (Asignaturas) obj;
		if (Caracter == null) {
			if (other.Caracter != null)
				return false;
		} else if (!Caracter.equals(other.Caracter))
			return false;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Duracion == null) {
			if (other.Duracion != null)
				return false;
		} else if (!Duracion.equals(other.Duracion))
			return false;
		if (Idiomas_Imparticion == null) {
			if (other.Idiomas_Imparticion != null)
				return false;
		} else if (!Idiomas_Imparticion.equals(other.Idiomas_Imparticion))
			return false;
		if (Ofertada != other.Ofertada)
			return false;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		if (Unidad_Temporal == null) {
			if (other.Unidad_Temporal != null)
				return false;
		} else if (!Unidad_Temporal.equals(other.Unidad_Temporal))
			return false;
		return true;
	}
	
	
   
}
