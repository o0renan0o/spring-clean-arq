package br.com.bradesco.core.factory;

import br.com.bradesco.core.usecases.altera.AlteraApelidoUseCase;
import br.com.bradesco.core.usecases.altera.AlteraChaveUseCase;
import br.com.bradesco.core.domain.gateway.input.AlteraApelidoInput;
import br.com.bradesco.core.domain.gateway.input.AlteraChaveInput;

/**
 * Factory for http input, creates all objects for http communication.
 */
public class HttpInputFactory {

    /**
     *
     * @param alteraApelido
     * @return AlteraApelidoInput to input infrastructure
     */
    public static AlteraApelidoInput toAlteraApelidoInput(AlteraApelidoUseCase.InputValues alteraApelido) {
        return new AlteraApelidoInput(
                alteraApelido.alteraApelidoRequest().getName(),
                alteraApelido.alteraApelidoRequest().getEmail(),
                alteraApelido.alteraApelidoRequest().getAddress(),
                alteraApelido.alteraApelidoRequest().getPassword()
        );
    }

    /**
     *
     * @param alteraChave
     * @return AlteraChaveInput to input infrastructure
     */
    public static AlteraChaveInput toAlteraChaveInput(AlteraChaveUseCase.InputValues alteraChave) {
        return new AlteraChaveInput(
                alteraChave.alteraChaveRequest().getName(),
                alteraChave.alteraChaveRequest().getEmail()
        );
    }
}
