package br.com.core.domain.response;

import br.com.core.domain.gateway.output.AlteraChaveOutput;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlteraChaveResponse {
    String name;
    String email;
    public static AlteraChaveResponse from(AlteraChaveOutput alteraChave) {
        return new AlteraChaveResponse(
                alteraChave.getName(),
                alteraChave.getEmail()
        );
    }
}
