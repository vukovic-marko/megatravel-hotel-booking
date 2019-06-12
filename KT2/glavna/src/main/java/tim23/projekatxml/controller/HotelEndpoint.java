package tim23.projekatxml.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetSobaRequest;
import io.spring.guides.gs_producing_web_service.GetSobaResponse;
import io.spring.guides.gs_producing_web_service.Soba;

@Endpoint
public class HotelEndpoint {
	
	@PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "getSobaRequest")
	@ResponsePayload
	public GetSobaResponse getSobe(@RequestPayload GetSobaRequest req) {
		// TODO: implement getting rooms
		Soba soba = new Soba();
		soba.setBrojSobe(req.getBrojSobe());
		soba.setBrojKreveta(5);
		
		GetSobaResponse resp = new GetSobaResponse();
		resp.setSoba(soba);
		
		return resp;
	}
}
