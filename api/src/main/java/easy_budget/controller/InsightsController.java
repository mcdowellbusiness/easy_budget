package easy_budget.controller;

import easy_budget.service.openai.PromptBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("insights")
public class InsightsController {

    private final PromptBuilder promptBuilder;

    public InsightsController(PromptBuilder promptBuilder) {
        this.promptBuilder = promptBuilder;
    }
    
    @PostMapping("/insights")
    public String getInsights(@RequestBody String text) {
        return promptBuilder.make().baseInsightsPrompt().build();
    }
}
