package br.com.bradesco.core.domain.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlteraChaveRequestTest {
    @Test
    public void newInstance() {
        // given
        AlteraChaveRequest alteraChaveRequest = new AlteraChaveRequest("renan", "renan@live.com");
        AlteraChaveRequest alteraChaveRequestEmpty = new AlteraChaveRequest();

        // when

        // then
        assertThat(alteraChaveRequest.getName()).isEqualTo("renan");
        assertThat(alteraChaveRequest.getEmail()).isEqualTo("renan@live.com");
    }
}
