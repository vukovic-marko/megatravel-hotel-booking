package tim23.agent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.AgentClient;
import tim23.agent.DTO.TerminskiPlanCenaDTO;
import tim23.agent.FromDTO.TerminskiPlanCenaConverter;
import tim23.agent.model.Cena;
import tim23.agent.model.poruke.GetCenaResponse;
import tim23.agent.repository.TerminskiPlanCenaRepository;

@RestController
@RequestMapping(value = "/terminskiPlanCena")
public class TerminskiPlanCenaController {

	@Autowired
	private TerminskiPlanCenaRepository terminskiPlanCenaRepository;
	
	@Autowired
	private AgentClient client;
	
	@Autowired
	private TerminskiPlanCenaConverter terminskiPlanCenaConverter;
	
	@PostMapping("/addTerminskiPlanCena")
	public ResponseEntity<?> dodajTerminskiPlanCena(@RequestBody TerminskiPlanCenaDTO terminskiPlanCena){
		Cena zaDodavanje = terminskiPlanCenaConverter.convert(terminskiPlanCena);
		
		GetCenaResponse response = client.addPrice(zaDodavanje);
		
		Cena dodata = terminskiPlanCenaRepository.save(response.getCena());
		return new ResponseEntity<>(dodata,HttpStatus.OK);
	}
}
