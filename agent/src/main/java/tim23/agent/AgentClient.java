package tim23.agent;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import tim23.agent.model.poruke.GetAgentListRequest;
import tim23.agent.model.poruke.GetAgentListResponse;
import tim23.agent.model.poruke.GetAgentRequest;
import tim23.agent.model.poruke.GetAgentResponse;
import tim23.agent.model.poruke.GetReservationListRequest;
import tim23.agent.model.poruke.GetReservationListResponse;

public class AgentClient extends WebServiceGatewaySupport {
	
	public GetAgentResponse get(String username) { 
		GetAgentRequest request = new GetAgentRequest();
		request.setUsername(username);
		
		GetAgentResponse response = (GetAgentResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
						request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
	
	public GetAgentListResponse getList(String username) {
		GetAgentListRequest request = new GetAgentListRequest();
		request.setUsername(username);
		
		GetAgentListResponse response = (GetAgentListResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
						request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
	
	public GetReservationListResponse getReservationList(String username) {
		GetReservationListRequest request = new GetReservationListRequest();
		request.setUsername(username);
		
		GetReservationListResponse response = (GetReservationListResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
						request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
}
