package easy_budget;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import easy_budget.model.Transaction;
import easy_budget.repository.TransactionRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionTest {

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	void shouldSaveAndRetrieveTransaction() {
		// Create a transaction with a fixed timestamp
		String testDate = LocalDateTime.now().toString();
		
		Transaction transaction = new Transaction();
		transaction.setAmount(100);
		transaction.setDescription("Test transaction");
		transaction.setDate(testDate);
		transaction.setCategory("Test category");
		transaction.setType("Test type");
		
		// Save the transaction
		Transaction savedTransaction = transactionRepository.save(transaction);
		
		// Verify the transaction was saved
		assertThat(transactionRepository.findAll()).isNotEmpty();
		assertThat(transactionRepository.findAll()).hasSize(1);
		
		// Verify the saved transaction has correct values
		assertThat(savedTransaction.getAmount()).isEqualTo(100);
		assertThat(savedTransaction.getDescription()).isEqualTo("Test transaction");
		assertThat(savedTransaction.getDate()).isEqualTo(testDate);
		assertThat(savedTransaction.getCategory()).isEqualTo("Test category");
		assertThat(savedTransaction.getType()).isEqualTo("Test type");
		assertThat(savedTransaction.getId()).isNotNull();
	}
} 