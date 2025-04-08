package br.com.infrastructure.gateway.exception;

import br.com.core.exception.GatewayHttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class HttpException implements ResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().is5xxServerError()) {
            if (response.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
                throw new GatewayHttpException("Service is currently unavailable -> Code: " +
                        response.getStatusCode().value() +
                        " Status: " +
                        response.getStatusText());
            }
        } else if (response.getStatusCode().is4xxClientError()) {
            if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new GatewayHttpException("Unauthorized access -> Code: " +
                        response.getStatusCode().value() +
                        " Status: " +
                        response.getStatusText());
            }
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }
}
