package org.marcossousadev.exception;

public class PersonasNotFound extends RuntimeException {
    public PersonasNotFound(String message) {
        super(message);
    }
}
