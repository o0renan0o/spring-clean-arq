package br.com.app.config;

import br.com.core.interfaces.infra.GatewayExecutor;
import br.com.infrastructure.gateway.Gateway;
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
