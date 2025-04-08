package br.com.bradesco.app.exception;

import br.com.bradesco.app.exception.ResponseExceptionHandler;
import br.com.bradesco.core.exception.CustomException;
import br.com.bradesco.core.exception.NotFoundException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ResponseExceptionHandlerTest {

    ResponseExceptionHandler exceptionHandler = new ResponseExceptionHandler();


    /**
     * Exception and UnknownError returns HttpStatus.INTERNAL_SERVER_ERROR
     */
    @Test
    public void handleExceptionReturnsInternalServerError() {
        // given
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        Message exceptionMessage = new Message("Erro interno do sistema.");
        NotFoundException exception = new NotFoundException("Erro interno do sistema.");
        WebRequest WebRequest = mock(WebRequest.class);
        // when
        ResponseEntity<CustomException> actual = exceptionHandler.handleAllExceptions(exception, WebRequest);

        // then
        assertResponse(actual, exceptionMessage, httpStatus);
    }

    /**
     * BadRequest returns HttpStatus.PRECONDITION_FAILED
     */
    @Test
    public void handleExceptionReturnsNotFoundException() {
        // given
        HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;
        Message exceptionMessage = new Message("Error");
        NotFoundException exception = new NotFoundException("Error");
        WebRequest WebRequest = mock(WebRequest.class);
        // when
        ResponseEntity<CustomException> actual = exceptionHandler.handleNotFoundExceptions(exception, WebRequest);

        // then
        assertResponse(actual, exceptionMessage, httpStatus);
    }

    /**
     * ObjectMapperException returns HttpStatus.PRECONDITION_FAILED
     */
    @Test
    public void handleExceptionReturnsObjectMapperException() {
        // given
        HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;
        Message exceptionMessage = new Message("Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        NotFoundException exception = new NotFoundException("Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        WebRequest WebRequest = mock(WebRequest.class);
        // when
        ResponseEntity<CustomException> actual = exceptionHandler.handleObjectMapperExceptions(exception, WebRequest);

        // then
        assertResponse(actual, exceptionMessage, httpStatus);
    }

    /**
     * GatewayHttpException returns HttpStatus.PRECONDITION_FAILED
     */
    @Test
    public void handleExceptionReturnsGatewayHttpException() {
        // given
        HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;
        Message exceptionMessage = new Message("Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        NotFoundException exception = new NotFoundException("Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        WebRequest WebRequest = mock(WebRequest.class);
        // when
        ResponseEntity<CustomException> actual = exceptionHandler.handleGatewayHttpExceptions(exception, WebRequest);

        // then
        assertResponse(actual, exceptionMessage, httpStatus);
    }

    private void assertResponse(ResponseEntity<CustomException> actual, Message exceptionMessage, HttpStatus httpStatus) {
        assertThat(actual.getStatusCode()).isEqualTo(httpStatus);
        assertThat(Objects.requireNonNull(actual.getBody()).getMessage()).isEqualToComparingFieldByField(exceptionMessage);
        assertThat(actual.getBody().getStatus()).isEqualTo(httpStatus.value());
    }

    private record Message(String mensagem) {}
}
