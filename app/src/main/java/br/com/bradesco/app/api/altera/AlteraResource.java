package br.com.bradesco.app.api.altera;

import br.com.bradesco.core.domain.request.AlteraApelidoRequest;
import br.com.bradesco.core.domain.request.AlteraChaveRequest;
import br.com.bradesco.core.domain.response.AlteraApelidoResponse;
import br.com.bradesco.core.domain.response.AlteraChaveResponse;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public interface AlteraResource {

    @Operation(summary = "alterar-apelido")
    @RequestMapping(
            value = "/alterar-apelido",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    CompletableFuture<AlteraApelidoResponse> alteraApelido(@Valid @RequestBody AlteraApelidoRequest validaPosseCelRequest);

    @Operation(summary = "alterar-chave")
    @RequestMapping(
            value = "/alterar-chave",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    CompletableFuture<AlteraChaveResponse> alteraChave(@Valid @RequestBody AlteraChaveRequest alteraChaveRequest);

}
