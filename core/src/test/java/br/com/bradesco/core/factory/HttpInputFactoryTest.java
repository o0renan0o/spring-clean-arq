package br.com.bradesco.core.factory;

import br.com.bradesco.core.domain.gateway.input.AlteraApelidoInput;
import br.com.bradesco.core.domain.gateway.input.AlteraChaveInput;
import br.com.bradesco.core.domain.request.AlteraApelidoRequest;
import br.com.bradesco.core.domain.request.AlteraChaveRequest;
import br.com.bradesco.core.usecases.altera.AlteraApelidoUseCase;
import br.com.bradesco.core.usecases.altera.AlteraChaveUseCase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpInputFactoryTest {

    @Test
    public void toAlteraApelidoInput() {
        AlteraApelidoUseCase.InputValues input = new AlteraApelidoUseCase.InputValues(new AlteraApelidoRequest("renan", "renan@live.com","smpw14", "1234"));
        AlteraApelidoInput alteraApelidoInput = HttpInputFactory.toAlteraApelidoInput(input);

        assertThat(alteraApelidoInput.getName()).isEqualTo("renan");
        assertThat(alteraApelidoInput.getEmail()).isEqualTo("renan@live.com");
        assertThat(alteraApelidoInput.getAddress()).isEqualTo("smpw14");
        assertThat(alteraApelidoInput.getPassword()).isEqualTo("1234");
    }

    @Test
    public void toAlteraChaveInput() {
        AlteraChaveUseCase.InputValues input = new AlteraChaveUseCase.InputValues(new AlteraChaveRequest("renan", "renan@live.com"));
        AlteraChaveInput alteraChaveInput = HttpInputFactory.toAlteraChaveInput(input);

        assertThat(alteraChaveInput.getName()).isEqualTo("renan");
        assertThat(alteraChaveInput.getEmail()).isEqualTo("renan@live.com");
    }
}
