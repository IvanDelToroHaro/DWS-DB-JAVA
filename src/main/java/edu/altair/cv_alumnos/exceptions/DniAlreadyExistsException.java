package edu.altair.cv_alumnos.exceptions;

public class DniAlreadyExistsException extends RuntimeException {
    public DniAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
}
