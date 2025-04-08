package br.com.bradesco.core.domain.response;

import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlteraApelidoResponse {
    String name;
    String email;
    String address;
    String password;
    public static AlteraApelidoResponse from(AlteraApelidoOutput alteraApelido) {
        return new AlteraApelidoResponse(
                alteraApelido.getName(),
                alteraApelido.getEmail(),
                alteraApelido.getAddress(),
                alteraApelido.getPassword()
        );
    }
}
