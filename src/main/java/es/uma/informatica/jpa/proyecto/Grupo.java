package es.uma.informatica.jpa.proyecto;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Number;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GRUPO
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id
	@Column( nullable = false, length = 255)
	private String ID;
	@Column( nullable = false, length = 20,unique = true)
	private String Curso;
	@Column( nullable = false, length = 1,unique = true)
	private String Letra;
	@Column( nullable = false, length = 20)
	private String Turno_Ma�ana_Tarde;
	@Column( nullable = false)
	private Number Plazas;
	@Column( nullable = false)
	private Boolean Ingl�s;
	private Boolean Visible;
	private Boolean Asignable;
	//private Number Codigo;
	//private String ID1;
	@Column(length = 1)
	private String Grupo_preferente;
	private static final long serialVersionUID = 1L;

	public Grupo() {
		super();
	}   
	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}   
	public String getCurso() {
		return this.Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}   
	public String getLetra() {
		return this.Letra;
	}

	public void setLetra(String Letra) {
		this.Letra = Letra;
	}   
	public String getTurno_Ma�ana_Tarde() {
		return this.Turno_Ma�ana_Tarde;
	}

	public void setTurno_Ma�ana_Tarde(String Turno_Ma�ana_Tarde) {
		this.Turno_Ma�ana_Tarde = Turno_Ma�ana_Tarde;
	}   
	public Number getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Number Plazas) {
		this.Plazas = Plazas;
	}   
	public Boolean getIngl�s() {
		return this.Ingl�s;
	}

	public void setIngl�s(Boolean Ingl�s) {
		this.Ingl�s = Ingl�s;
	}   
	public Boolean getVisible() {
		return this.Visible;
	}

	public void setVisible(Boolean Visible) {
		this.Visible = Visible;
	}   
	public Boolean getAsignable() {
		return this.Asignable;
	}

	public void setAsignable(Boolean Asignable) {
		this.Asignable = Asignable;
	}   
	/*
	public Number getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Number Codigo) {
		this.Codigo = Codigo;
	}   
	public String getID1() {
		return this.ID1;
	}

	public void setID1(String ID1) {
		this.ID1 = ID1;
	}   
	*/
	public String getGrupo_preferente() {
		return this.Grupo_preferente;
	}

	public void setGrupo_preferente(String Grupo_preferente) {
		this.Grupo_preferente = Grupo_preferente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Asignable == null) ? 0 : Asignable.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Grupo_preferente == null) ? 0 : Grupo_preferente.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Ingl�s == null) ? 0 : Ingl�s.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((Turno_Ma�ana_Tarde == null) ? 0 : Turno_Ma�ana_Tarde.hashCode());
		result = prime * result + ((Visible == null) ? 0 : Visible.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Asignable == null) {
			if (other.Asignable != null)
				return false;
		} else if (!Asignable.equals(other.Asignable))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Grupo_preferente == null) {
			if (other.Grupo_preferente != null)
				return false;
		} else if (!Grupo_preferente.equals(other.Grupo_preferente))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Ingl�s == null) {
			if (other.Ingl�s != null)
				return false;
		} else if (!Ingl�s.equals(other.Ingl�s))
			return false;
		if (Letra == null) {
			if (other.Letra != null)
				return false;
		} else if (!Letra.equals(other.Letra))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (Turno_Ma�ana_Tarde == null) {
			if (other.Turno_Ma�ana_Tarde != null)
				return false;
		} else if (!Turno_Ma�ana_Tarde.equals(other.Turno_Ma�ana_Tarde))
			return false;
		if (Visible == null) {
			if (other.Visible != null)
				return false;
		} else if (!Visible.equals(other.Visible))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GRUPO [ID=" + ID + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno_Ma�ana_Tarde="
				+ Turno_Ma�ana_Tarde + ", Plazas=" + Plazas + ", Ingl�s=" + Ingl�s + ", Visible=" + Visible
				+ ", Asignable=" + Asignable + ", Grupo_preferente=" + Grupo_preferente + "]";
	}
   
}
