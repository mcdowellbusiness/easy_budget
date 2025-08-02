package easy_budget.controller;

import easy_budget.service.openai.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("llm")
public class LlmController {

    private final OpenAiService openAiService;

    public LlmController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    // Simple endpoint for testing your AI connection
    @PostMapping("/ask")
    public String ask(@RequestBody AskRequest request) {
        return openAiService.answerQuestion(request.question());
    }

    // Example endpoint for summarizing text
    @PostMapping("/summarize")
    public String summarize(@RequestBody SummarizeRequest request) {
        return openAiService.summarizeText(request.text());
    }

    // Example endpoint for categorizing a transaction
    @PostMapping("/categorize")
    public String categorize(@RequestBody CategorizeRequest request) {
        return openAiService.categorizeTransaction(request.transactionDescription());
    }

    // Request DTOs
    public record AskRequest(String question) {}
    public record SummarizeRequest(String text) {}
    public record CategorizeRequest(String transactionDescription) {}
}
