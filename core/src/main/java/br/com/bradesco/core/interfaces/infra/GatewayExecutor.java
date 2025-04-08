package br.com.bradesco.core.interfaces.infra;

import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;

public interface GatewayExecutor {
    AlteraApelidoOutput postAlteraApelido(Object payload);
    AlteraChaveOutput postAlteraChave(Object payload);
    AlteraChaveOutput postAlteraChavePrincipal(Object payload);
    AlteraChaveOutput postConsultaChave(Object payload);
    AlteraChaveOutput postConsultaChavesMultiplas(Object payload);
    AlteraChaveOutput postCriaChaveEfetivacao(Object payload);
    AlteraChaveOutput postCriaChaveIntencao(Object payload);
    AlteraChaveOutput postExcluiChave(Object payload);
    AlteraChaveOutput postExcluiChavePrecadastro(Object payload);
    AlteraChaveOutput postListaChaves(Object payload);
}
