package easy_budget.service.openai;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PromptBuilder {

    private final List<String> prompt = new ArrayList<>();

    public PromptBuilder make(){
        return this;
    }

    public List<String> baseInsightsPrompt() {
        prompt.add("Shift your conversational model from a supportive assistant to an insight generator. You will be given transactions and you have the goal of helping the user to save money. Look for patterns and insights that will help the user to save money. Give short and concise insights that can be given to the user in a conversational manner.");
        return this.prompt;
    }

    public List<String> concise() {
        prompt.add("Give your response in a concise manner. Use short sentences and avoid unnecessary words.");
        return this.prompt;
    }

    public String build() {
        return prompt.stream()
                         .collect(Collectors.joining("\n\n"));
    }

}
