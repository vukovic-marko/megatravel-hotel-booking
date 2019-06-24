package tim23.hotelservice.endpoint;

import java.util.List;

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
import tim23.hotelservice.model.Rezervacija;
import tim23.hotelservice.model.Soba;
import tim23.hotelservice.model.poruke.GetAgentListRequest;
import tim23.hotelservice.model.poruke.GetAgentListResponse;
import tim23.hotelservice.model.poruke.GetAgentRequest;
import tim23.hotelservice.model.poruke.GetAgentResponse;
import tim23.hotelservice.model.poruke.GetReservationListRequest;
import tim23.hotelservice.model.poruke.GetReservationListResponse;
import tim23.hotelservice.model.poruke.GetSobaRequest;
import tim23.hotelservice.model.poruke.GetSobaResponse;
import tim23.hotelservice.repository.AgentRepository;
import tim23.hotelservice.repository.RezervacijaRepository;
import tim23.hotelservice.repository.SobaRepository;

@Endpoint
public class HotelEndpoint {
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	private SobaRepository sobaRepository;
	
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAgentRequest")
    @ResponsePayload
	public GetAgentResponse getAgent(@RequestPayload GetAgentRequest request) {
		Agent a = agentRepository.findByUsername(request.getUsername());
    	
		GetAgentResponse response = new GetAgentResponse();
		response.setAgent(a);
		
		return response;
	}
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAgentListRequest")
    @ResponsePayload
    public GetAgentListResponse getAgentList(@RequestPayload GetAgentListRequest request) {
    	List<Agent> a = agentRepository.findAll();
    	
    	GetAgentListResponse response = new GetAgentListResponse();
    	response.setAgent(a);
    	
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getReservationListRequest")
    @ResponsePayload
    public GetReservationListResponse getReservationList(@RequestPayload GetReservationListRequest request) {
    	List<Rezervacija> r = rezervacijaRepository.findAll();
    	
    	GetReservationListResponse response = new GetReservationListResponse();
    	response.setReservations(r);
    	
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSobaRequest")
    @ResponsePayload
    public GetSobaResponse getSoba(@RequestPayload GetSobaRequest request) {
    	
    	Soba s = request.getSoba();
    	Soba soba = sobaRepository.save(s);

    	GetSobaResponse response = new GetSobaResponse();
    	response.setSoba(soba);
    	
    	return response;
    }
}
