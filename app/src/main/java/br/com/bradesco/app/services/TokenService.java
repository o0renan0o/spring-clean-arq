package br.com.bradesco.app.services;

import br.com.bradesco.core.domain.commom.Token;
import br.com.bradesco.core.exception.TokenException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private HttpServletRequest request;

    public Token extractXStatelessOpen() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectMapper mapper = new ObjectMapper();

            // Captura o Header Authorization.
            final String authorizationFinal = request.getHeader("Authorization");
            String authorization = request.getHeader("Authorization");
            if (authorization == null) throw new Exception("Authorization token is null.");

            //Retira a primeira camada do token.
            String jwtToken = authorization.substring(7); // remove "Bearer " do token
            String[] jwtTokenChunks = jwtToken.split("\\.");
            Base64.Decoder decoder = Base64.getUrlDecoder();

            //Retira a segunda camada x-stateless-open.
            String jwtTokenPayload = new String(decoder.decode(jwtTokenChunks[1]));
            JsonNode jsonNode = objectMapper.readTree(jwtTokenPayload);
            String tokenStatelessOpen = jsonNode.get("x-stateless-open").asText();
            if (tokenStatelessOpen == null) throw new Exception("x-stateless-open token is null.");

            String[] StatelessOpenChunks = tokenStatelessOpen.split("\\.");
            String StatelessOpen = new String(decoder.decode(StatelessOpenChunks[1]));

            // Insere o Authorization ao json.
            Map<String, Object> jsonMap = objectMapper.readValue(StatelessOpen, new TypeReference<Map<String,Object>>(){});
            jsonMap.put("authorization", authorizationFinal);
            String StatelessOpenPayload = objectMapper.writeValueAsString(jsonMap);

            // Retorna o objeto Token apra uso em toda a aplicação.
            return mapper.readValue(StatelessOpenPayload, Token.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new TokenException(e.getMessage());
        }
    }
}
