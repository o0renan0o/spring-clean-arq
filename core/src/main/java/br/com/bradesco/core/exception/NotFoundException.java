package br.com.bradesco.core.exception;

public class NotFoundException extends DomainException {
    public NotFoundException(String message) {
        super(message);
    }
}
