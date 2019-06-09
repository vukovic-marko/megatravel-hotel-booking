package tim23.agent;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetSobaRequest;
import hello.wsdl.GetSobaResponse;

public class SobaClient extends WebServiceGatewaySupport {

	public GetSobaResponse get(int brojSobe) {
		GetSobaRequest req = new GetSobaRequest();
		req.setBrojSobe(brojSobe);
		
		GetSobaResponse resp = (GetSobaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/poruke", req,
						new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetSobaRequest"));
		
		return resp;
	}
}
