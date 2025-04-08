//package br.com.bradesco.core.usecases.altera;
//
//import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
//import br.com.bradesco.core.domain.request.AlteraApelidoRequest;
//import br.com.bradesco.core.domain.response.AlteraApelidoResponse;
//import br.com.bradesco.core.exception.NotFoundException;
//import br.com.bradesco.core.interfaces.infra.HttpExecutor;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AlteraApelidoUseCaseTest {
//
//    @Configuration
//    @ComponentScan(basePackages = {"com.bradesco.core.usecases.altera"})
//    static class Config {
//    }
//    @InjectMocks
//    private AlteraApelidoUseCase alteraApelidoUseCase;
//
//    @Mock
//    private HttpExecutor<AlteraApelidoOutput> httpAlteraApelidoExecutor;
//
//    @Test
//    public void alteraApelidoUseCase() {
//        // given
//        AlteraApelidoUseCase.InputValues input = new AlteraApelidoUseCase.InputValues(new AlteraApelidoRequest("test", "renan@live.com","smpw14", "1234"));
//        AlteraApelidoOutput alteraApelidoOutput = new AlteraApelidoOutput("renan", "renan@live.com", "smpw14", "1234");
//        AlteraApelidoResponse alteraApelidoResponse = AlteraApelidoResponse.from(alteraApelidoOutput);
//
//        // when
//        when(httpAlteraApelidoExecutor.post(any())).thenReturn(alteraApelidoOutput);
//        final AlteraApelidoResponse actual = alteraApelidoUseCase.execute(input).alteraApelido();
//
//        // then
//        assertThat(actual).isEqualToComparingFieldByField(alteraApelidoResponse);
//    }
//
//    @Test
//    public void alteraApelidoUseCaseNotFoundException() {
//        // when
//        when(httpAlteraApelidoExecutor.post(any())).thenReturn(null);
//        Exception exception = assertThrows(NotFoundException.class, () -> alteraApelidoUseCase.validResponse(null));
//
//        // then
//        assertEquals("Erro ao alterar o apelido!", exception.getMessage());
//    }
//}
