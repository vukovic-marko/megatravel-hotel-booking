package tim23.projekatxml.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.entiteti.Soba;
import rs.ac.uns.ftn.poruke.GetSobaRequest;

@Endpoint
public class HotelEndpoint {
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSobaRequest")
	@ResponsePayload
	public Soba getSobe(@RequestPayload GetSobaRequest req) {
		// TODO: implement getting rooms
		Soba soba = new Soba();
		soba.setBrojSobe(req.getRoomNumber());
		
		return soba;
	}
}
