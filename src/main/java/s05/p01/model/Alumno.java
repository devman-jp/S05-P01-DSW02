package s05.p01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO")
	private Integer idAlumno;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "PATERNO")
	private String paterno;
	
	@Column(name = "MATERNO")
	private String materno;
	
	@Column(name = "IQ")
	private Integer iq;
	
	@Column(name = "EDAD")
	private Integer edad;
	
	public Alumno() {
		
	}

	public Alumno(Integer idAlumno, String nombres, String paterno, String materno, Integer iq, Integer edad) {
		this.idAlumno = idAlumno;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.iq = iq;
		this.edad = edad;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Integer getIq() {
		return iq;
	}

	public void setIq(Integer iq) {
		this.iq = iq;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
