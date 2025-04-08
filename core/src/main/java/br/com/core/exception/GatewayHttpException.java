package br.com.core.exception;


public class GatewayHttpException extends DomainException {
    public GatewayHttpException(String message) {
        super(message);
    }
}
