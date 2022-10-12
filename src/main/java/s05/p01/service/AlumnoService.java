package s05.p01.service;

import java.util.List;

import s05.p01.model.Alumno;

public interface AlumnoService {

	List<Alumno> lista();
	Alumno obtener(Integer idAlumno);
	Alumno guardar(Alumno alumno);
	Alumno actualizar(Alumno alumno);
	Alumno eliminar(Integer idAlumno);
	
}
