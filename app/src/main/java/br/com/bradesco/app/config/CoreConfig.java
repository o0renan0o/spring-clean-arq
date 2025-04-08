package br.com.bradesco.app.config;

import br.com.bradesco.core.interfaces.infra.GatewayExecutor;
import br.com.bradesco.core.usecases.altera.AlteraApelidoUseCase;
import br.com.bradesco.core.usecases.altera.AlteraChaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    public AlteraApelidoUseCase alteraApelidoUseCase(GatewayExecutor gatewayExecutor){
        return new AlteraApelidoUseCase(gatewayExecutor);
    }

    @Bean
    public AlteraChaveUseCase alteraChaveUseCase(GatewayExecutor gatewayExecutor){
        return new AlteraChaveUseCase(gatewayExecutor);
    }

}
