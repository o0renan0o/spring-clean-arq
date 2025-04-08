package br.com.core.domain.gateway.output;
import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlteraChaveOutput {
    String name;
    String email;
    String address;
    String password;
}
