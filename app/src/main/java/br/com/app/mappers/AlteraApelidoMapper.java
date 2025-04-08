package br.com.app.mappers;

import br.com.app.services.TokenService;
import br.com.core.domain.request.AlteraApelidoRequest;
import br.com.core.usecases.altera.AlteraApelidoUseCase;
import org.springframework.stereotype.Service;

@Service
public class AlteraApelidoMapper {

    private final TokenService tokenService;

    public AlteraApelidoMapper(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public AlteraApelidoUseCase.InputValues map(AlteraApelidoRequest alteraApelidoRequest) {
        alteraApelidoRequest.setToken(this.tokenService.extractXStatelessOpen());
        return new AlteraApelidoUseCase.InputValues(alteraApelidoRequest);
    }
}
