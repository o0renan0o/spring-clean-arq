//package br.com.bradesco.core.usecases.altera;
//
//import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;
//import br.com.bradesco.core.domain.request.AlteraChaveRequest;
//import br.com.bradesco.core.domain.response.AlteraChaveResponse;
//import br.com.bradesco.core.exception.NotFoundException;
//import br.com.bradesco.core.interfaces.infra.HttpExecutor;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AlteraChaveUseCaseTest {
//
//    @Configuration
//    @ComponentScan(basePackages = {"com.bradesco.core.usecases.altera"})
//    static class Config {
//    }
//
//    @InjectMocks
//    private AlteraChaveUseCase alteraChaveUseCase;
//
//    @Mock
//    private HttpExecutor<AlteraChaveOutput> httpAlteraChaveExecutor;
//
//    @Test
//    public void alteraChaveUseCase() {
//        // given
//        AlteraChaveUseCase.InputValues input = new AlteraChaveUseCase.InputValues(new AlteraChaveRequest("test", "renan@live.com"));
//        AlteraChaveOutput alteraChaveOutput = new AlteraChaveOutput("renan", "renan@live.com", "smpw14", "1234");
//        AlteraChaveResponse alteraChaveResponse = AlteraChaveResponse.from(alteraChaveOutput);
//
//        // when
//        when(httpAlteraChaveExecutor.post(any())).thenReturn(alteraChaveOutput);
//        final AlteraChaveResponse actual = alteraChaveUseCase.execute(input).alteraChave();
//
//        // then
//        assertThat(actual).isEqualToComparingFieldByField(alteraChaveResponse);
//    }
//
//    @Test
//    public void alteraChaveUseCaseNotFoundException() {
//        // when
//        when(httpAlteraChaveExecutor.post(any())).thenReturn(null);
//        Exception exception = assertThrows(NotFoundException.class, () -> alteraChaveUseCase.validResponse(null));
//
//        // then
//        assertEquals("Erro ao alterar a chave!", exception.getMessage());
//    }
//}
