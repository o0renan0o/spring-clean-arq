package br.com.app.config;

import br.com.core.interfaces.infra.GatewayExecutor;
import br.com.core.usecases.altera.AlteraApelidoUseCase;
import br.com.core.usecases.altera.AlteraChaveUseCase;
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
