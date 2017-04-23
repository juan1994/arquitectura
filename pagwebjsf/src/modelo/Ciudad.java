package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Ciudad" database table.
 * 
 */
@Entity
@Table(name="\"Ciudad\"")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"IdCiudad\"", unique=true, nullable=false)
	private Integer idCiudad;

	@Column(name="\"IdDepartamento\"")
	private Integer idDepartamento;

	@Column(name="\"NombreCiudad\"", length=30)
	private String nombreCiudad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumns(name="IdDepartamento", nullable=false)
	private Departamento departamento;

	public Ciudad() {
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}