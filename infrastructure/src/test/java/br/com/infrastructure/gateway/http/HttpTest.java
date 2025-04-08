//package br.com.bradesco.infrastructure.gateway.http;
//
//import br.com.bradesco.core.domain.gateway.output.AlteraApelidoOutput;
//import br.com.bradesco.infrastructure.http.Http;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import org.mockito.ArgumentMatchers;
//import org.springframework.http.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootConfiguration
//@SpringBootTest
//public class HttpTest {
//
//    @TestConfiguration
//    static class Config {
//
//        @Bean
//        public RestTemplate restTemplate() {
//            return new RestTemplate();
//        }
////        @Bean
////        public Http<AlteraApelidoOutput> alteraApelido() {
////            return new Http<>(AlteraApelidoOutput.class, "https://a20d6475-3784-4bbe-a1e7-7463fa8ccfb9.mock.pstmn.io/api/test", new RestTemplate());
////        }
//    }
//
//    @Mock
//    private RestTemplate restTemplate;
//
////    @BeforeEach
////    public void setUp() {
////        this.restTemplate.setErrorHandler(new HttpException());
////    }
//
////    @Autowired
////    private Http<AlteraApelidoOutput> httpAlteraApelido;
//
//    @Test
//    public void httpGet() throws Exception {
//        Http<AlteraApelidoOutput> httpAlteraApelido = new Http<>(AlteraApelidoOutput.class);
//
//        AlteraApelidoOutput alteraApelidoOutput = new AlteraApelidoOutput("renan", "renan@live.com", "smpw14", "1234");
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(alteraApelidoOutput);
//
//        ResponseEntity<String> jsonReturn = new ResponseEntity<>(json, HttpStatus.ACCEPTED);
//
//        when(restTemplate.exchange(
//                ArgumentMatchers.any(String.class),
//                ArgumentMatchers.any(HttpMethod.class),
//                ArgumentMatchers.any(HttpEntity.class),
//                ArgumentMatchers.eq(String.class)
//        )).thenReturn(jsonReturn);
//
//        AlteraApelidoOutput alteraApelidoOutputs = null;
//
//        assertThat(alteraApelidoOutputs).isNotNull();
//    }
//
//    @Test
//    public void httpPost() throws Exception {
//        Http<AlteraApelidoOutput> httpAlteraApelido = new Http<>(AlteraApelidoOutput.class);
//
//        AlteraApelidoOutput alteraApelidoOutput = new AlteraApelidoOutput("renan", "renan@live.com", "smpw14", "1234");
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(alteraApelidoOutput);
//
//        ResponseEntity<String> jsonReturn = new ResponseEntity<>(json, HttpStatus.ACCEPTED);
//
//        when(restTemplate.exchange(
//                ArgumentMatchers.any(String.class),
//                ArgumentMatchers.any(HttpMethod.class),
//                ArgumentMatchers.any(HttpEntity.class),
//                ArgumentMatchers.eq(String.class)
//        )).thenReturn(jsonReturn);
//
//        AlteraApelidoOutput alteraApelidoOutputs = httpAlteraApelido.post(alteraApelidoOutput);
//
//        assertThat(alteraApelidoOutputs).isNotNull();
//    }
//}
