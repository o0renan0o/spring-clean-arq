package br.com.core.domain.response;

import br.com.core.domain.gateway.output.AlteraApelidoOutput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// TODO testar a serialização e desserialização de objetos

public class AlteraApelidoResponseTest {
    @Test
    public void newInstance() {
        // given
        AlteraApelidoOutput AlteraApelidoOutput = new AlteraApelidoOutput("renan", "renan@live.com", "smpw14", "1234");
        AlteraApelidoResponse AlteraApelidoResponseEmpty = new AlteraApelidoResponse();
        // when
        AlteraApelidoResponse alteraApelidoResponse = AlteraApelidoResponse.from(AlteraApelidoOutput);
        // then
        assertThat(alteraApelidoResponse.getName()).isEqualTo("renan");
        assertThat(alteraApelidoResponse.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraApelidoResponse.getAddress()).isEqualTo("smpw14");
        assertThat(alteraApelidoResponse.getPassword()).isEqualTo("1234");
    }
}
