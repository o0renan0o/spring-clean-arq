package br.com.infrastructure.gateway.http.dto.output;

import br.com.core.domain.gateway.output.AlteraChaveOutput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlteraChaveOutputTest {
    @Test
    public void newInstance() {
        // given
        AlteraChaveOutput alteraChaveRequest = new AlteraChaveOutput("renan", "renan@live.com", "smpw14", "1234");
        new AlteraChaveOutput();

        // then
        assertThat(alteraChaveRequest.getName()).isEqualTo("renan");
        assertThat(alteraChaveRequest.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraChaveRequest.getAddress()).isEqualTo("smpw14");
        assertThat(alteraChaveRequest.getPassword()).isEqualTo("1234");
    }

}
