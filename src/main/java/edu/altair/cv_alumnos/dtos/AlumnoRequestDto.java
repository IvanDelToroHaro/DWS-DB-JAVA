package edu.altair.cv_alumnos.dtos;
import java.time.LocalDate;
public record AlumnoRequestDto(
        String dni,
        String nombre,
        String apellidos,
        LocalDate fechaNacimiento,
        String telefono,
        String email,
        String matricula,
        String programa
) {}
