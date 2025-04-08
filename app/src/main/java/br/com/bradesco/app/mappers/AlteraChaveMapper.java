package br.com.bradesco.app.mappers;


import br.com.bradesco.app.services.TokenService;
import br.com.bradesco.core.domain.request.AlteraChaveRequest;
import br.com.bradesco.core.usecases.altera.AlteraChaveUseCase;
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
