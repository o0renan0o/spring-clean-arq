//package br.com.bradesco.app.web.config;
//
//import br.com.bradesco.app.config.EnvironmentProperties;
//import br.com.bradesco.core.interfaces.infra.HttpExecutor;
//import br.com.bradesco.core.usecases.altera.AlteraApelidoUseCase;
//import br.com.bradesco.core.usecases.altera.AlteraChaveUseCase;
//import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
//import br.com.bradesco.core.domain.gateway.output.AlteraChaveOutput;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class HttpConfigTest {
//
//    @Autowired
//    EnvironmentProperties environment;
//    @MockBean
//    Logger logger;
//    @MockBean
//    HttpExecutor<AlteraApelidoOutput> httpAlteraApelidoExecutor;
//    @MockBean
//    HttpExecutor<AlteraChaveOutput> httpAlteraChaveExecutor;
//    @Autowired
//    AlteraApelidoUseCase alteraApelidoUseCase;
//    @Autowired
//    AlteraChaveUseCase alteraChaveUseCase;
//
//    @Test
//    void alteraApelidoUseCase() {
//        assertNotNull(alteraApelidoUseCase);
//    }
//
//    @Test
//    void alteraChaveUseCase() {
//        assertNotNull(alteraChaveUseCase);
//    }
//
//}
