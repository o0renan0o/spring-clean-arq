package br.com.app.mappers;


import br.com.app.services.TokenService;
import br.com.core.domain.request.AlteraChaveRequest;
import br.com.core.usecases.altera.AlteraChaveUseCase;
import org.springframework.stereotype.Service;

@Service
public class AlteraChaveMapper {

    private final TokenService tokenService;

    public AlteraChaveMapper(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public AlteraChaveUseCase.InputValues map(AlteraChaveRequest alteraChaveRequest) {
        alteraChaveRequest.setToken(this.tokenService.extractXStatelessOpen());
        return new AlteraChaveUseCase.InputValues(alteraChaveRequest);
    }
}
