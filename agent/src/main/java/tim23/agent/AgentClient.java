package tim23.agent;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import tim23.agent.model.poruke.GetAgentRequest;
import tim23.agent.model.poruke.GetAgentResponse;

public class AgentClient extends WebServiceGatewaySupport {
	
	public GetAgentResponse get(String username) { 
		GetAgentRequest request = new GetAgentRequest();
		request.setUsername(username);
		
		GetAgentResponse response = (GetAgentResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
						request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
}
