package br.com.infrastructure.gateway;

import br.com.infrastructure.gateway.exception.HttpException;
import br.com.infrastructure.gateway.mapper.HttpObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Http<T> {

    final Class<T> genericClass;
    private final RestTemplate restTemplate;

    public Http(Class<T> genericClass) {
        this.genericClass = genericClass;
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(new HttpException());
    }

    public T get(String url) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "*/*");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class);

        return new HttpObjectMapper<T>().fromJson(response.getBody(), genericClass);
    }

    public T post(String url, Object payload) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "*/*");

        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestEntity = new HttpObjectMapper<T>().toJson(payload);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(requestEntity, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        return new HttpObjectMapper<T>().fromJson(response.getBody(), genericClass);

    }
}
