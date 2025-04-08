package br.com.core.domain.request;

import br.com.core.domain.commom.Token;
import lombok.*;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class AlteraApelidoRequest {
    @NonNull String name;
    @NonNull String email;
    @NonNull String address;
    @NonNull String password;
    @Setter Token token;
}
