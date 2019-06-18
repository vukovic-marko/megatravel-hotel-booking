package tim23.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tim23.searchservice.config.JwtConfig;

@SpringBootApplication
public class SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

}
