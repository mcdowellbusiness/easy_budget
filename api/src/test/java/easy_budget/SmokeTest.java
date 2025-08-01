package easy_budget;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import easy_budget.controller.HealthController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

	@Autowired
	private HealthController healthController;

	@Test
	void shouldReturnDefaultMessage() {
		assertThat(this.healthController.ping()).contains("pong");
	}
} 