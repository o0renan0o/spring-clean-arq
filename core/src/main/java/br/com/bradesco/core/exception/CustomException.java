package br.com.bradesco.core.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CustomException {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    /**
     * Codigo de retorno
     */
    private Integer status;

    /**
     * Menssagem padrao de retorno
     */
    private Message message;


    public CustomException(LocalDateTime now, Integer status, String message) {
        this.status = status;
        this.timestamp = now;
        this.message = new Message(message);
    }

    public record Message(String mensagem) {}


    public Integer getStatus() {
        return status;
    }


    public Message getMessage() {
        return this.message;
    }

}
