package br.com.bradesco.infrastructure.gateway;

import br.com.bradesco.core.domain.env.Environment;
import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;
import br.com.bradesco.core.interfaces.infra.GatewayExecutor;
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

    // Arrumar em diante

    @CircuitBreaker(name = "POST_SRV_ALETRA_CHAVE_PRINCIPAL")
    @Override
    public AlteraChaveOutput postAlteraChavePrincipal(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    // Consulta

    @CircuitBreaker(name = "POST_SRV_CONSULTA_CHAVE")
    @Override
    public AlteraChaveOutput postConsultaChave(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_CONSULTA_CHAVES_MULTIPLAS")
    @Override
    public AlteraChaveOutput postConsultaChavesMultiplas(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_CONSULTA_CHAVE_EFETIVACAO")
    @Override
    public AlteraChaveOutput postCriaChaveEfetivacao(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_CONSULTA_CHAVE_INTENCAO")
    @Override
    public AlteraChaveOutput postCriaChaveIntencao(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_EXCLUI_CHAVE")
    @Override
    public AlteraChaveOutput postExcluiChave(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_EXCLUI_CHAVE_PRECADASTRO")
    @Override
    public AlteraChaveOutput postExcluiChavePrecadastro(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }

    @CircuitBreaker(name = "POST_SRV_LISTA_CHAVES")
    @Override
    public AlteraChaveOutput postListaChaves(Object payload) {
        return alteraChaveExecutor.post(environment.getBspiSrvAlteraChave().getUrl() +
                        environment.getBspiSrvAlteraChave().getEndpoints().getAlteraApelido(),
                payload);
    }


}
