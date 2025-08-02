package easy_budget.infastructure.openai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class OpenAiClient {

    @Value("${openai.api.key}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.openai.com/v1";

    public String chatResponse(String model, String prompt) {
        String url = BASE_URL + "/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> message = Map.of("role", "user", "content", prompt);
        
        Map<String, Object> body = Map.of(
                "model", model,
                "messages", List.of(message),
                "max_tokens", 1000
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }

    public String getTextResponse(String prompt) {
        try {
            String rawJson = chatResponse("gpt-4o-mini", prompt);

            // Parse JSON to extract the text output
            JsonNode root = objectMapper.readTree(rawJson);

            // The text output for chat completions is inside "choices[0].message.content"
            return root.path("choices")
                       .path(0)
                       .path("message")
                       .path("content")
                       .asText();

        } catch (Exception e) {
            throw new RuntimeException("Error parsing OpenAI response", e);
        }
    }
}
