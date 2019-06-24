package tim23.agent;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import tim23.agent.model.Soba;
import tim23.agent.model.poruke.GetAdresaListRequest;
import tim23.agent.model.poruke.GetAdresaListResponse;
import tim23.agent.model.poruke.GetAgentListRequest;
import tim23.agent.model.poruke.GetAgentListResponse;
import tim23.agent.model.poruke.GetAgentRequest;
import tim23.agent.model.poruke.GetAgentResponse;
import tim23.agent.model.poruke.GetReservationListRequest;
import tim23.agent.model.poruke.GetReservationListResponse;
import tim23.agent.model.poruke.GetSobaRequest;
import tim23.agent.model.poruke.GetSobaResponse;
import tim23.agent.model.poruke.GetTipSmestajaListRequest;
import tim23.agent.model.poruke.GetTipSmestajaListResponse;

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
	
	public GetSobaResponse getSoba(Soba soba) {
		GetSobaRequest request = new GetSobaRequest();
		request.setSoba(soba);
		
		GetSobaResponse response = (GetSobaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
					request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
	
	public GetAdresaListResponse getAdrese() {
		GetAdresaListRequest request = new GetAdresaListRequest();
		GetAdresaListResponse response = (GetAdresaListResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
					request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
	
	public GetTipSmestajaListResponse getTip() {
		GetTipSmestajaListRequest request = new GetTipSmestajaListRequest();
		GetTipSmestajaListResponse response = (GetTipSmestajaListResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8762/hotel-service/ws/poruke",
					request, new SoapActionCallback("http://www.ftn.uns.ac.rs/poruke"));
		
		return response;
	}
}
