package br.com.bradesco.app.config;

import br.com.bradesco.app.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EnvironmetPropertiesTest {


    @Autowired
    EnvironmentConfig environment;

    @Test
    public void EnvironmetProperties() {
        assertNotNull(environment.getBspiSrvAlteraChaveBanco().getUrl());
        assertNotNull(environment.getBspiSrvAlteraChaveBanco().getEndpoints().getAlteraApelido());
        assertNotNull(environment.getBspiSrvAlteraChaveBanco().getEndpoints().getAlteraChave());
    }
}
