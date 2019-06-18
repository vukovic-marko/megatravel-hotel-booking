package tim23.agent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

//@Configuration
public class SobaConfig {
	
//	@Bean
//	public Jaxb2Marshaller marshaller() {
//		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//		// this package must match the package in the <generatePackage> specified in
//		// pom.xml
//		marshaller.setContextPath("hello.wsdl");
//		return marshaller;
//	}
//	
//	@Bean
//	public SobaClient countryClient(Jaxb2Marshaller marshaller) {
//		SobaClient client = new SobaClient();
//		client.setDefaultUri("http://localhost:8762/hotel-service/ws");
//		client.setMarshaller(marshaller);
//		client.setUnmarshaller(marshaller);
//		return client;
//	}
}
