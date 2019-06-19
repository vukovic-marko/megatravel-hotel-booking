package tim23.agent.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.model.Adresa;
import tim23.agent.model.TipSmestaja;
import tim23.agent.service.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController {
	
	@Autowired
	public AgentService as;
	
	@GetMapping("/sviTipoviSmestaja")
	public ResponseEntity<?> allTypesOfRooms(){
		List<TipSmestaja> lista=as.findAllTypesOfRooms();
		Set<String> set=new HashSet<String>();
		for(TipSmestaja ts:lista) {
			set.add(ts.getNaziv());
			//System.out.println(ts.getNaziv());
		}
		return new ResponseEntity<>(set,HttpStatus.OK);
		//return set;
	}
	
	@GetMapping("/sveAdrese")
	public ResponseEntity<?> allAddresses(){
		List<Adresa> lista=as.findAllAddresses();
		for(Adresa a:lista) {
			System.out.println(a.getGrad());
		}
		return new ResponseEntity<>(as.findAllAddresses(),HttpStatus.OK);
	}
	

}
