package br.com.bradesco.infrastructure.gateway.http.dto.output;

import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AlteraApelidoOutputTest {
    @Test
    public void newInstance() {
        // given
        AlteraApelidoOutput alteraApelidoRequest = new AlteraApelidoOutput("renan", "renan@live.com", "smpw14", "1234");
        new AlteraApelidoOutput();

        // when

        // then
        assertThat(alteraApelidoRequest.getName()).isEqualTo("renan");
        assertThat(alteraApelidoRequest.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraApelidoRequest.getAddress()).isEqualTo("smpw14");
        assertThat(alteraApelidoRequest.getPassword()).isEqualTo("1234");
    }
}
