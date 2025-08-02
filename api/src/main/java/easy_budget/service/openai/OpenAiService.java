package easy_budget.service.openai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import easy_budget.infastructure.openai.OpenAiClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    private final OpenAiClient openAiClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OpenAiService(OpenAiClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    /**
     * Low-level helper: sends prompt to OpenAI and extracts just the text output.
     */
    public String getTextResponse(String prompt) {
        try {
            String rawJson = openAiClient.chatResponse("gpt-4o-mini", prompt);

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

    /**
     * Example: Summarize some text.
     */
    public String summarizeText(String text) {
        String prompt = "Summarize the following text:\n\n" + text;
        return getTextResponse(prompt);
    }

    /**
     * Example: Answer a question concisely.
     */
    public String answerQuestion(String question) {
        String prompt = "Answer the following question concisely:\n" + question;
        return getTextResponse(prompt);
    }

    /**
     * Example: Turn a bank transaction into a budget category.
     */
    public String categorizeTransaction(String transactionDescription) {
        String prompt = String.format(
                "Categorize this bank transaction into one of: Food, Bills, Entertainment, Travel, Miscellaneous:\n\n%s",
                transactionDescription
        );
        return getTextResponse(prompt);
    }
} 