package easy_budget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "easy_budget.repository")
@EntityScan(basePackages = "easy_budget.model")
public class EasyBudgetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBudgetApiApplication.class, args);
	}

}
