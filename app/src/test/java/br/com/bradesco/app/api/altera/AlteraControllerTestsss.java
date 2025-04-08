//package com.bradesco.app.web.api.altera;
//
//import com.bradesco.app.web.api.commom.BaseControllerTest;
//import com.bradesco.app.web.mappers.AlteraApelidoInputMapper;
//import com.bradesco.app.web.mappers.AlteraChaveInputMapper;
//import com.bradesco.app.web.usecase.UseCaseExecutorImpl;
//import com.bradesco.core.domain.request.AlteraApelidoRequest;
//import com.bradesco.core.domain.response.AlteraApelidoResponse;
//import com.bradesco.core.factory.HttpInputFactory;
//import com.bradesco.core.usecases.altera.AlteraApelidoUseCase;
//import com.bradesco.core.usecases.altera.AlteraChaveUseCase;
//import com.bradesco.infrastructure.gateway.http.HttpExecutor;
//import com.bradesco.infrastructure.gateway.http.dto.input.AlteraApelidoInput;
//import com.bradesco.infrastructure.gateway.http.dto.output.AlteraApelidoOutput;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.hamcrest.Matchers.is;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = AlteraController.class)
//public class AlteraControllerTest extends BaseControllerTest {
//
//    @Configuration
//    @ComponentScan(basePackages = {"com.bradesco.app.web.api.altera", "com.bradesco.app.web.api.commom"})
//    static class Config {
//    }
//
//    @SpyBean
//    private UseCaseExecutorImpl useCaseExecutor;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AlteraApelidoUseCase alteraApelidoUseCase;
//
//    @MockBean
//    private AlteraChaveUseCase alteraChaveUseCase;
//    @MockBean
//    private AlteraChaveInputMapper alteraChaveInputMapper;
//    @MockBean
//    private AlteraApelidoInputMapper alteraApelidoInputMapper;
//
//    @Override
//    protected MockMvc getMockMvc() {
//        return mockMvc;
//    }
//
//    @Before
//    public void setUp() {
//        JacksonTester.initFields(this, new ObjectMapper());
//    }
//
//    private JacksonTester<AlteraApelidoRequest> alteraApelidoRequestJson;
//
//    @Test
//    public void alteraApelidoForbidden() throws Exception {
//
//        // given
//        AlteraApelidoRequest alteraApelidoRequest = new AlteraApelidoRequest("renan", "renan@live.com","smpw14", "1234");
////        AlteraApelidoRequest alteraApelidoRequest = mock(AlteraApelidoRequest.class);
//        String payload = this.alteraApelidoRequestJson.write(alteraApelidoRequest).getJson();
//
////        AlteraApelidoUseCase.InputValues input = mock(AlteraApelidoUseCase.InputValues.class);
////        AlteraApelidoUseCase.OutputValues output = mock(AlteraApelidoUseCase.OutputValues.class);
//
//        AlteraApelidoUseCase.InputValues input = new AlteraApelidoUseCase.InputValues(alteraApelidoRequest);
//        AlteraApelidoUseCase.OutputValues output = new AlteraApelidoUseCase.OutputValues(new AlteraApelidoResponse("renan", "renan@live.com","smpw14", "1234"));
//
////        AlteraApelidoOutput alteraApelidoOutput = spy(httpAlteraApelidoExecutor).post(input);
////        when(alteraApelidoOutput).thenReturn(new AlteraApelidoOutput("renan", "renan@live.com","smpw14", "1234"));
////
////        AlteraApelidoUseCase.OutputValues alteraApelidoOutputCase = spy(alteraApelidoUseCase).execute(input);
////        when(alteraApelidoOutputCase).thenReturn(output);
////
////        AlteraApelidoUseCase outputValues = mock(AlteraApelidoUseCase.class);
////        Mockito.when(outputValues.execute(input)).thenReturn(output);
//
//        // and
//        doReturn(output)
//                .when(alteraApelidoUseCase)
//                .execute(input);
//
////        when(alteraApelidoUseCase.execute(input)).thenReturn(output);
//
//        // when
//        RequestBuilder request = asyncPostRequest("/api/alterar-apelido", payload);
//
//        // then
//        mockMvc.perform(request)
//                .andExpect(status().is2xxSuccessful());
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$.success", is(false)))
////                .andExpect(jsonPath("$.message", is("Error")));
//    }
//}
