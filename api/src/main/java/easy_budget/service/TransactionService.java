package easy_budget.service;

import easy_budget.model.Transaction;
import easy_budget.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Get all transactions
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * Get a transaction by ID
     */
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    /**
     * Create a new transaction
     */
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Update an existing transaction
     */
    public Optional<Transaction> updateTransaction(Long id, Transaction transaction) {
        return transactionRepository.findById(id)
                .map(existing -> {
                    transaction.setId(id); // Ensure the ID matches
                    return transactionRepository.save(transaction);
                });
    }

    /**
     * Delete a transaction by ID
     */
    public boolean deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Get transactions by category
     */
    public List<Transaction> getTransactionsByCategory(String category) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> category.equals(transaction.getCategory()))
                .toList();
    }

    /**
     * Get total amount for a specific category
     */
    public double getTotalAmountByCategory(String category) {
        return getTransactionsByCategory(category).stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
} 