package edu.altair.cv_alumnos.exceptions;

public class AlumnoNotFoundException extends RuntimeException {
    public AlumnoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
