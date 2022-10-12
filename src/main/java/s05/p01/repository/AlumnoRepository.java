package s05.p01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s05.p01.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

}
