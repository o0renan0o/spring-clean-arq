package br.com.app.api.altera;


import br.com.app.mappers.AlteraApelidoMapper;
import br.com.app.mappers.AlteraChaveMapper;
import br.com.core.domain.request.AlteraApelidoRequest;
import br.com.core.domain.request.AlteraChaveRequest;
import br.com.core.domain.response.AlteraApelidoResponse;
import br.com.core.domain.response.AlteraChaveResponse;
import br.com.core.interfaces.usecases.UseCaseExecutor;
import br.com.core.usecases.altera.AlteraApelidoUseCase;
import br.com.core.usecases.altera.AlteraChaveUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Component
public class AlteraController implements AlteraResource {

    private final UseCaseExecutor useCaseExecutor;
    private final AlteraApelidoUseCase alteraApelidoUseCase;
    private final AlteraChaveUseCase alteraChaveUseCase;
    private final AlteraApelidoMapper alteraApelidoMapper;
    private final AlteraChaveMapper alteraChaveMapper;

    public AlteraController(UseCaseExecutor useCaseExecutor,
                            AlteraApelidoUseCase alteraApelidoUseCase,
                            AlteraChaveUseCase alteraChaveUseCase,
                            AlteraApelidoMapper alteraApelidoMapper,
                            AlteraChaveMapper alteraChaveMapper) {
        this.alteraApelidoMapper = alteraApelidoMapper;
        this.alteraChaveMapper = alteraChaveMapper;
        this.alteraApelidoUseCase = alteraApelidoUseCase;
        this.alteraChaveUseCase = alteraChaveUseCase;
        this.useCaseExecutor = useCaseExecutor;
    }

    @Override
    public CompletableFuture<AlteraApelidoResponse> alteraApelido(@Valid @RequestBody AlteraApelidoRequest alteraApelidoRequest) {
        return useCaseExecutor.execute(
                alteraApelidoUseCase,
                alteraApelidoMapper.map(alteraApelidoRequest),
                AlteraApelidoUseCase.OutputValues::alteraApelido);
    }

    @Override
    public CompletableFuture<AlteraChaveResponse> alteraChave(@Valid @RequestBody AlteraChaveRequest validaChaveRequest) {
        return useCaseExecutor.execute(
                alteraChaveUseCase,
                alteraChaveMapper.map(validaChaveRequest),
                AlteraChaveUseCase.OutputValues::alteraChave);
    }

}
