package br.com.core.interfaces.infra;

import br.com.core.domain.gateway.output.AlteraApelidoOutput;
import br.com.core.domain.gateway.output.AlteraChaveOutput;

public interface GatewayExecutor {
    AlteraApelidoOutput postAlteraApelido(Object payload);
    AlteraChaveOutput postAlteraChave(Object payload);
}
