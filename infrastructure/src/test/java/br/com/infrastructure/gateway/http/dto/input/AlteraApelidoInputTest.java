package br.com.infrastructure.gateway.http.dto.input;

import br.com.core.domain.gateway.input.AlteraApelidoInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlteraApelidoInputTest {
    @Test
    public void newInstance() {
        // given
        AlteraApelidoInput alteraApelidoRequest = new AlteraApelidoInput("renan", "renan@live.com", "smpw14", "1234");
        new AlteraApelidoInput();

        // when

        // then
        assertThat(alteraApelidoRequest.getName()).isEqualTo("renan");
        assertThat(alteraApelidoRequest.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraApelidoRequest.getAddress()).isEqualTo("smpw14");
        assertThat(alteraApelidoRequest.getPassword()).isEqualTo("1234");
    }
}
