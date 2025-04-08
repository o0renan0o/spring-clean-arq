package br.com.bradesco.app.exception;

import br.com.bradesco.core.exception.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@Log4j2
@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler({ Exception.class, UnknownError.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<CustomException> handleAllExceptions(Exception ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro interno do sistema.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public final ResponseEntity<CustomException> handleHttpMessageNotReadableException(Exception ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Required request body is missing.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({ NotFoundException.class })
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public final ResponseEntity<CustomException> handleNotFoundExceptions(Exception ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({ ObjectMapperException.class })
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public final ResponseEntity<CustomException> handleObjectMapperExceptions(Exception ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({ GatewayHttpException.class })
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public final ResponseEntity<CustomException> handleGatewayHttpExceptions(Exception ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Sistema indisponível no momento. Por favor tente novamente mais tarde.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseEntity<CustomException> handleMissingHeader(MissingRequestHeaderException ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Authorization header is missing.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseEntity<CustomException> handleMissingHeader(JsonProcessingException ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Token error.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ResponseEntity<CustomException> handleMissingHeader(TokenException ex, WebRequest request) {
        logError(ex, request);
        var exceptionResponse = new CustomException(LocalDateTime.now(), HttpStatus.PRECONDITION_FAILED.value(), "Token error.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }
    private void logError(Exception ex, WebRequest request) {
        log.error("BFF-CHAVE-SERVICE ERROR: {}", ex.getMessage());
    }
    /**
     * 'HYSTRIX-FALLBACK': { status: 412, message: [{ mensagem: 'Sistema indisponível no momento. Por favor tente novamente mais tarde.' }] },
     *   'JOI-MISSING-FIELDS': { status: 412, message: [{ mensagem: 'Sistema indisponível no momento. Por favor tente novamente mais tarde.' }] },
     *   'DIGITO-INVALIDO': { status: 412, message: [{ mensagem: 'Dígito da conta inválido.' }] },
     *   'CONTA-DIVERGENTE': { status: 412, message: [{ mensagem: 'Dados da conta enviada não conferem com a cadastrada.' }] },
     *   default: { status: 500, message: [{ mensagem: 'Erro interno do sistema.' }] },
     */
}
