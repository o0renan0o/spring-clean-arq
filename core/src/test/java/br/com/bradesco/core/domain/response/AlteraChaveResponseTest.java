package br.com.bradesco.core.domain.response;

import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlteraChaveResponseTest {
    @Test
    public void newInstance() {
        // given
        AlteraChaveOutput alteraChaveOutput = new AlteraChaveOutput("renan", "renan@live.com", "smpw14", "1234");
        AlteraChaveResponse AlteraChaveResponseEmpty = new AlteraChaveResponse();
        // when
        AlteraChaveResponse alteraChaveResponse = AlteraChaveResponse.from(alteraChaveOutput);
        // then
        assertThat(alteraChaveResponse.getName()).isEqualTo("renan");
        assertThat(alteraChaveResponse.getEmail()).isEqualTo("renan@live.com");
    }
}
