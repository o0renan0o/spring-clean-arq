package br.com.bradesco.infrastructure.gateway.mapper;

import br.com.bradesco.core.exception.ObjectMapperException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpObjectMapper<T> {
    public T fromJson(String httpResponse, Class<T>  genericClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(httpResponse, genericClass);
        } catch (JsonProcessingException ex) {
            throw new ObjectMapperException(ex.getMessage());
        }
    }

    public String toJson(Object payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException ex) {
            throw new ObjectMapperException(ex.getMessage());
        }
    }
}
