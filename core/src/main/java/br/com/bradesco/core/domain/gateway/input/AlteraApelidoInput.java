package br.com.bradesco.core.domain.gateway.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlteraApelidoInput {
    String name;
    String email;
    String address;
    String password;
}
