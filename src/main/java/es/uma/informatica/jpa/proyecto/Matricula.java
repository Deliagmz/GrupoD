package es.uma.informatica.jpa.proyecto;

import com.sun.tools.javac.util.List;
import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity

public class Matricula implements Serializable {

	   
	@Id
	private String Curso_academico;
	private String Estado;
	private Integer Num_Archivo;
	private String Turno_Preferente;
	private Date Fecha_de_matricula;
	private Boolean Nuevo_ingreso;
	private List Listado_Asignaturas;
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
	public List getListado_Asignaturas() {
		return this.Listado_Asignaturas;
	}

	public void setListado_Asignaturas(List Listado_Asignaturas) {
		this.Listado_Asignaturas = Listado_Asignaturas;
	}
   
}
