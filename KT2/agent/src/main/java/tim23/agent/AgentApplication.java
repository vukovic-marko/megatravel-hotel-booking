package tim23.agent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.wsdl.GetSobaResponse;

@SpringBootApplication
public class AgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(SobaClient quoteClient) {
		return args -> {
			int soba = 4;

			if (args.length > 0) {
				soba = Integer.valueOf(args[0]);
			}
			GetSobaResponse response = quoteClient.get(soba);
			System.out.println(response.getSoba().getBrojSobe());
			System.out.println(response.getSoba().getBrojKreveta());
		};
	}

}
