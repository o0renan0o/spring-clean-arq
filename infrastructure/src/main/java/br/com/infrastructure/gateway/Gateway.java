package br.com.infrastructure.gateway;

import br.com.core.domain.env.Environment;
import br.com.core.domain.gateway.output.AlteraApelidoOutput;
import br.com.core.domain.gateway.output.AlteraChaveOutput;
import br.com.core.interfaces.infra.GatewayExecutor;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class Gateway implements GatewayExecutor {

    private final Environment environment;
    private final Http<AlteraApelidoOutput> alteraApelidoExecutor = new Http<>(AlteraApelidoOutput.class);
    private final Http<AlteraChaveOutput> alteraChaveExecutor = new Http<>(AlteraChaveOutput.class);

    public Gateway(Environment environment) {
        this.environment = environment;
    }

    // Altera

    @CircuitBreaker(name = "POST_SRV_ALTERA_APELIDO")
    @Override
    public AlteraApelidoOutput postAlteraApelido(Object payload) {
        return alteraApelidoExecutor.post(environment.getBspiSrvAlteraChaveBanco().getUrl() +
                        environment.getBspiSrvAlteraChaveBanco().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_ALTERA_CHAVE_APELIDO")
    @Override
    public AlteraChaveOutput postAlteraChave(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

}
