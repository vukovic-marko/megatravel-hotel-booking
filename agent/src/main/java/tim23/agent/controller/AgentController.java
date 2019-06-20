package tim23.agent.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.DTO.SobaDTO;
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
	
	@PostMapping("/addRoom")
	public void addRoom(@RequestBody SobaDTO soba){
		System.out.println(soba.getBroj_sobe()+" "+soba.getBroj_kreveta()+" "+soba.getOpis()+" "+soba.getAdresa().getId()+" "+soba.getTipSmestaja().getIdTipa()+" "+soba.getIdSobe());
		//ovde ti prosledjujem broj sobe,broj kreveta,opis,adresu celu ne DTO i tip smestaja ceo
		//naziv tipa smestaja mora biti jedinstven jer findujem po njemu
		//ti treba ostalo da setujes
	}
	
	@GetMapping("/sveAdrese")
	public ResponseEntity<?> allAddresses(){
		//List<Adresa> lista=as.findAllAddresses();
//		for(Adresa a:lista) {
//			System.out.println(a.getGrad());
//		}
		return new ResponseEntity<>(as.findAllAddresses(),HttpStatus.OK);
	}
	@GetMapping("/adresaId/{id}")
	public Adresa addressById(@PathVariable Integer id) {
		//Adresa a=as.findAddressById(id);
		//System.out.println("Adresa "+a.getId());
		return as.findAddressById(id);
	}
	@GetMapping("/typeRoomNaziv/{naziv}")
	public TipSmestaja typeRoomByNaziv(@PathVariable String naziv) {
		//System.out.println("tip "+ as.findTypeRoomByNaziv(naziv));
		return as.findTypeRoomByNaziv(naziv);
	}

}
