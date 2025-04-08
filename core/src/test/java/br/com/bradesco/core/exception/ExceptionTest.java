package br.com.bradesco.core.exception;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest {

    @Test
    public void exceptionNotFoundException() {
        NotFoundException notFoundException = new NotFoundException("Error");
        assertThat(notFoundException.getMessage()).isEqualTo("Error");
    }

    @Test
    public void exceptionCustomException() {
        CustomException customException = new CustomException(LocalDateTime.now(), 500, "Erro interno do sistema.");
        assertThat(customException.getMessage().mensagem()).isEqualTo("Erro interno do sistema.");
        assertThat(customException.getStatus()).isEqualTo(500);
    }
}
