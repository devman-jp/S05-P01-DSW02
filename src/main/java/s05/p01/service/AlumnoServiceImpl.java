package s05.p01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s05.p01.model.Alumno;
import s05.p01.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	public List<Alumno> lista() {
		return repository.findAll();
	}

	@Override
	public Alumno obtener(Integer idAlumno) {
		return repository.findById(idAlumno).orElse(null);
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		if(alumno.getIdAlumno() != null) {
			return null;
		}
		Alumno validateAlumno = validarAlumno(alumno);
		repository.save(validateAlumno);
		List<Alumno> listadoAlumnos = lista();
		return listadoAlumnos.get(listadoAlumnos.size() - 1);
	}

	@Override
	public Alumno actualizar(Alumno alumno) {
		Alumno validateAlumno = validarAlumno(alumno);
		repository.saveAndFlush(validateAlumno);
		return repository.findById(alumno.getIdAlumno()).orElse(null);
	}

	@Override
	public Alumno eliminar(Integer idAlumno) {
		if(idAlumno == null) {
			return null;
		}
		Alumno deletedAlumno = repository.findById(idAlumno).orElse(null);
		if(deletedAlumno == null) {
			return null;
		}
		repository.deleteById(idAlumno);
		return deletedAlumno;
	}

	public Alumno validarAlumno(Alumno alumno) {
		if(alumno.getEdad() <= 0) {
			return null;
		}
		if(alumno.getIq() <= 0) {
			return null;
		}
		if(alumno.getNombres().length() == 0 || alumno.getNombres().length() < 3) {
			return null;
		}
		if(alumno.getPaterno().length() == 0 || alumno.getPaterno().length() < 3) {
			return null;
		}
		if(alumno.getMaterno().length() == 0 || alumno.getMaterno().length() < 3) {
			return null;
		}
		return alumno;
	}
	
}
