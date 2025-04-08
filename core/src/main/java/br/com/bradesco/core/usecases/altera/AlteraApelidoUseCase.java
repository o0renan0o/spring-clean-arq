package br.com.bradesco.core.usecases.altera;

import br.com.bradesco.core.domain.request.AlteraApelidoRequest;
import br.com.bradesco.core.interfaces.infra.GatewayExecutor;
import br.com.bradesco.core.usecases.UseCase;
import br.com.bradesco.core.domain.gateway.input.AlteraApelidoInput;
import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
import br.com.bradesco.core.domain.response.AlteraApelidoResponse;
import br.com.bradesco.core.factory.HttpInputFactory;
import br.com.bradesco.core.exception.NotFoundException;

public class AlteraApelidoUseCase extends UseCase<AlteraApelidoUseCase.InputValues, AlteraApelidoUseCase.OutputValues> {

    private final GatewayExecutor gatewayExecutor;

    public AlteraApelidoUseCase(GatewayExecutor gatewayExecutor){
        this.gatewayExecutor = gatewayExecutor;
    }

    @Override
    public AlteraApelidoUseCase.OutputValues
    execute(AlteraApelidoUseCase.InputValues input) {

        AlteraApelidoInput httpInput = HttpInputFactory.toAlteraApelidoInput(input);

        AlteraApelidoOutput response = gatewayExecutor.postAlteraApelido(httpInput);

        validResponse(response);

        AlteraApelidoResponse alteraApelido = AlteraApelidoResponse.from(response);

        return new AlteraApelidoUseCase.OutputValues(alteraApelido);

    }

    public void validResponse(AlteraApelidoOutput response) {
        if (response == null){
            throw new NotFoundException("Erro ao alterar o apelido!");
        }
    }

    public record InputValues(AlteraApelidoRequest alteraApelidoRequest) implements UseCase.InputValues {
    }
    public record OutputValues(AlteraApelidoResponse alteraApelido) implements UseCase.OutputValues {
    }
}