package br.com.core.domain.request;

import br.com.core.domain.commom.Token;
import lombok.*;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class AlteraChaveRequest {
    @NonNull String name;
    @NonNull String email;
    @Setter Token token;
}
