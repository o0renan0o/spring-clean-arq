package br.com.app.api.altera;

import br.com.app.api.commom.BaseControllerTest;
import br.com.core.domain.request.AlteraApelidoRequest;
import br.com.core.domain.request.AlteraChaveRequest;
import br.com.core.domain.response.AlteraApelidoResponse;
import br.com.core.domain.response.AlteraChaveResponse;
import br.com.core.exception.NotFoundException;
import br.com.core.usecases.altera.AlteraApelidoUseCase;
import br.com.core.usecases.altera.AlteraChaveUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class AlteraControllerTest extends BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlteraApelidoUseCase alteraApelidoUseCase;

    @MockBean
    private AlteraChaveUseCase alteraChaveUseCase;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Test
    public void alteraApelidoReturnsNotFound() throws Exception {
        // given
        AlteraApelidoRequest alteraApelidoRequest = new AlteraApelidoRequest("renan", "renan@live.com", "smpw14", "1234");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(alteraApelidoRequest);

        // and
        when(alteraApelidoUseCase.execute(any())).thenThrow(new NotFoundException("Error"));

        // when
        RequestBuilder request = asyncPostRequest("/api/alterar-apelido", json);

        // then
        this.mockMvc.perform(request)
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void alteraApelidoReturnsOk() throws Exception {
        // given
        AlteraApelidoRequest alteraApelidoRequest = new AlteraApelidoRequest("renan", "renan@live.com", "smpw14", "1234");
        AlteraApelidoUseCase.OutputValues output = new AlteraApelidoUseCase.OutputValues(new AlteraApelidoResponse("test", "renan@live.com","smpw14", "1234"));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(alteraApelidoRequest);

        // and
        when(alteraApelidoUseCase.execute(any())).thenReturn(output);

        // when
        RequestBuilder request = asyncPostRequest("/api/alterar-apelido", json);

        // then
        this.mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.email").exists());
    }

    @Test
    public void alteraChaveReturnsOk() throws Exception {
        // given
        AlteraChaveRequest alteraChaveRequest = new AlteraChaveRequest("renan", "renan@live.com");
        AlteraChaveUseCase.OutputValues output = new AlteraChaveUseCase.OutputValues(new AlteraChaveResponse("test", "renan@live.com"));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(alteraChaveRequest);

        // and
        when(alteraChaveUseCase.execute(any())).thenReturn(output);

        // when
        RequestBuilder request = asyncPostRequest("/api/alterar-chave", json);

        // then
        this.mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.email").exists());
    }
}
