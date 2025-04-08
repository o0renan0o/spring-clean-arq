package br.com.core.domain.env;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Environment {
    BspiSrvAlteraChaveBancoEnv bspiSrvAlteraChaveBanco;
    BspiSrvAlteraChaveEnv bspiSrvAlteraChave;

}
