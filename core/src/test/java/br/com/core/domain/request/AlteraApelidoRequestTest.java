package br.com.core.domain.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AlteraApelidoRequestTest {
    @Test
    public void newInstance() {
        // given
        AlteraApelidoRequest alteraApelidoRequest = new AlteraApelidoRequest("renan", "renan@live.com", "smpw14", "1234");
        AlteraApelidoRequest alteraApelidoRequestEmpty = new AlteraApelidoRequest();

        // when

        // then
        assertThat(alteraApelidoRequest.getName()).isEqualTo("renan");
        assertThat(alteraApelidoRequest.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraApelidoRequest.getAddress()).isEqualTo("smpw14");
        assertThat(alteraApelidoRequest.getPassword()).isEqualTo("1234");
    }
}
