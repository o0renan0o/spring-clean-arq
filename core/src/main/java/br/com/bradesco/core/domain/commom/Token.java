package br.com.bradesco.core.domain.commom;

public record Token(Token.Cliente cliente, String periferico, int idioma, int canal,
                    int empresa, String uuid, int dependencia, String authorization) {
    public record Cliente(String titularidade, String dac, String conta, String cpfCnpj, String razao, String agencia,
                          boolean pj00) {
    }
}
