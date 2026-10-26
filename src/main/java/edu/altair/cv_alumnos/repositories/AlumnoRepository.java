package edu.altair.cv_alumnos.repositories;

import edu.altair.cv_alumnos.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    // Método derivado para consultar si ya existe un DNI registrado
    boolean existsByDni(String dni);

    // Método derivado para buscar un alumno por su DNI
    Optional<Alumno> findByDni(String dni);
}
