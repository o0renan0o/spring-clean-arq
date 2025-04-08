package br.com.bradesco.core.usecases.altera;

import br.com.bradesco.core.interfaces.infra.GatewayExecutor;
import br.com.bradesco.core.usecases.UseCase;
import br.com.bradesco.core.domain.gateway.input.AlteraChaveInput;
import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;
import br.com.bradesco.core.domain.request.AlteraChaveRequest;
import br.com.bradesco.core.domain.response.AlteraChaveResponse;
import br.com.bradesco.core.factory.HttpInputFactory;
import br.com.bradesco.core.exception.NotFoundException;
public class AlteraChaveUseCase extends UseCase<AlteraChaveUseCase.InputValues, AlteraChaveUseCase.OutputValues> {

    private final GatewayExecutor gatewayExecutor;

    public AlteraChaveUseCase(GatewayExecutor gatewayExecutor){
        this.gatewayExecutor = gatewayExecutor;
    }
    @Override
    public OutputValues execute(AlteraChaveUseCase.InputValues input) {

        AlteraChaveInput httpInput = HttpInputFactory.toAlteraChaveInput(input);

        AlteraChaveOutput response = gatewayExecutor.postAlteraChave(httpInput);

        validResponse(response);

        AlteraChaveResponse alteraChave = AlteraChaveResponse.from(response);

        return new AlteraChaveUseCase.OutputValues(alteraChave);

    }

    public void validResponse(AlteraChaveOutput response) {
        if (response == null){
            throw new NotFoundException("Erro ao alterar a chave!");
        }
    }

    public record InputValues(AlteraChaveRequest alteraChaveRequest) implements UseCase.InputValues {
    }
    public record OutputValues(AlteraChaveResponse alteraChave) implements UseCase.OutputValues {
    }
}
