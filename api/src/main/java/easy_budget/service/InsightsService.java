package easy_budget.service;

import easy_budget.model.Transaction;
import easy_budget.service.openai.OpenAiService;
import easy_budget.service.openai.PromptBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsightsService {

    private final TransactionService transactionService;
    private final OpenAiService openAiService;
    private final PromptBuilder promptBuilder;

    public InsightsService(TransactionService transactionService, 
                         OpenAiService openAiService, 
                         PromptBuilder promptBuilder) {
        this.transactionService = transactionService;
        this.openAiService = openAiService;
        this.promptBuilder = promptBuilder;
    }

    /**
     * Generate insights from all transactions
     */
    public String transactionInsights() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        
        if (transactions.isEmpty()) {
            return "No transactions found. Add some transactions to get insights!";
        }

        // Build the prompt with transaction data
        String prompt = buildTransactionPrompt(transactions);
        
        // Get insights from OpenAI
        return openAiService.getTextResponse(prompt);
    }

    /**
     * Build a prompt with transaction data for OpenAI
     */
    private String buildTransactionPrompt(List<Transaction> transactions) {
        StringBuilder transactionData = new StringBuilder();
        
        for (Transaction transaction : transactions) {
            transactionData.append(String.format(
                "Transaction: %s | Amount: $%.2f | Category: %s | Date: %s\n",
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getCategory(),
                transaction.getDate()
            ));
        }

        // Build the prompt using PromptBuilder
        String prompt = promptBuilder.make()
                .baseInsightsPrompt()
                .concise()
                .build();

        // Add the transaction data to the prompt
        prompt += "\n\nTransaction Data:\n" + transactionData.toString();
        
        return prompt;
    }

} 