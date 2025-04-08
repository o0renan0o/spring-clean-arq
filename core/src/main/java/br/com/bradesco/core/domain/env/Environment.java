package br.com.bradesco.core.domain.env;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Environment {
    BspiSrvAlteraChaveBancoEnv bspiSrvAlteraChaveBanco;
    BspiSrvAlteraChaveEnv bspiSrvAlteraChave;

}
