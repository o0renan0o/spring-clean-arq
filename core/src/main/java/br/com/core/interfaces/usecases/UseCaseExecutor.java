package br.com.core.interfaces.usecases;

import br.com.core.usecases.UseCase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(
            UseCase<I, O> useCase,
            I input,
            Function<O, RX> outputMapper);
}
