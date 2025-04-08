package br.com.bradesco.app.config;

import br.com.bradesco.core.interfaces.infra.GatewayExecutor;
import br.com.bradesco.infrastructure.gateway.Gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final EnvironmentConfig environment;

    public GatewayConfig(EnvironmentConfig environment) {
        this.environment = environment;
    }

    @Bean
    public GatewayExecutor gateway() {
        return new Gateway(environment);
    }
}
