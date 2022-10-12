package s05.p01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import s05.p01.model.Alumno;
import s05.p01.service.AlumnoService;

@RestController
@RequestMapping("/alumno/v1")
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return new ResponseEntity<List<Alumno>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Alumno> insertarAlumno(@RequestBody Alumno alumno) {
		Alumno savedAlumno = service.guardar(alumno);
		return new ResponseEntity<Alumno>(savedAlumno, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/findAll/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable int codigo) {
		Alumno alumno = service.obtener(codigo);
		if(alumno == null) {			
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<Alumno> editarAlumno(@RequestBody Alumno alumno) 
	{
		Alumno foundAlumno = service.obtener(alumno.getIdAlumno());
		if(foundAlumno == null) {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		Alumno updatedAlumno = service.actualizar(alumno);
		return new ResponseEntity<Alumno>(updatedAlumno, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Alumno> eliminarAlumno(@PathVariable int codigo) 
	{
		Alumno foundAlumno = service.obtener(codigo);
		if(foundAlumno == null) {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		Alumno deletedAlumno = service.eliminar(codigo);
		return new ResponseEntity<Alumno>(deletedAlumno, HttpStatus.OK);
	}
	
}
