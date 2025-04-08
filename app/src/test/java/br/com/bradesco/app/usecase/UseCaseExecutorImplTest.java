package br.com.bradesco.app.usecase;

import br.com.bradesco.app.services.UseCaseExecutorImpl;
import br.com.bradesco.core.usecases.UseCase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UseCaseExecutorImplTest {
    @MockBean
    Logger logger;

    @InjectMocks
    UseCaseExecutorImpl cut;

    @Mock
    UseCase<UseCase.InputValues, UseCase.OutputValues> useCase;

    @Mock
    UseCase.InputValues input;

    @Mock
    UseCase.OutputValues output;

    @Mock
    UseCase.OutputValues expected;

    @Mock
    Function<UseCase.OutputValues, UseCase.OutputValues> outputMapper;

    @RepeatedTest(10)
    void alteraApelidoUseCase() {
        when(useCase.execute(input)).thenReturn(output);
        when(outputMapper.apply(output)).thenReturn(expected);

        CompletableFuture<UseCase.OutputValues> actual = cut.execute(useCase, input, outputMapper);

        // Then
        assertThat(actual).succeedsWithin(Duration.ofSeconds(5)).isEqualTo(expected);
    }

}
