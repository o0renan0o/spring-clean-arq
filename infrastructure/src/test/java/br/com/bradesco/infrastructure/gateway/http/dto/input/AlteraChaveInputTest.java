package br.com.bradesco.infrastructure.gateway.http.dto.input;

import br.com.bradesco.core.domain.gateway.input.AlteraChaveInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlteraChaveInputTest {
    @Test
    public void newInstance() {
        // given
        AlteraChaveInput alteraChaveRequest = new AlteraChaveInput("renan", "renan@live.com");
        new AlteraChaveInput();

        // when

        // then
        assertThat(alteraChaveRequest.getName()).isEqualTo("renan");
        assertThat(alteraChaveRequest.getEmail()).isEqualTo("renan@live.com");
    }
}
