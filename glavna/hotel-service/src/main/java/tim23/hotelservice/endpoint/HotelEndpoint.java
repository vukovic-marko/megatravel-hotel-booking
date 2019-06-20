package tim23.hotelservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import tim23.hotelservice.model.poruke.GetSobaRequest;
//import tim23.hotelservice.model.poruke.GetSobaResponse;
//import tim23.hotelservice.model.poruke.Soba;

import tim23.hotelservice.model.Agent;
import tim23.hotelservice.model.poruke.GetAgentRequest;
import tim23.hotelservice.model.poruke.GetAgentResponse;
import tim23.hotelservice.repository.AgentRepository;

@Endpoint
public class HotelEndpoint {
	
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSobaRequest")
//	@ResponsePayload
//	public GetSobaResponse getSobe(@RequestPayload GetSobaRequest req) {
//		// TODO: implement getting rooms
//		Soba soba = new Soba();
//		soba.setBrojSobe(req.getBrojSobe());
//		soba.setBrojKreveta(5);
//		
//		GetSobaResponse resp = new GetSobaResponse();
//		resp.setSoba(soba);
//		
//		return resp;
//	}
	
	@Autowired
	private AgentRepository agentRepository;
	
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAgentRequest")
    @ResponsePayload
	public GetAgentResponse getAgent(@RequestPayload GetAgentRequest request) {
		Agent a = agentRepository.findByUsername(request.getUsername());
    	
		GetAgentResponse response = new GetAgentResponse();
		response.setAgent(a);
		
		return response;
	}
}
