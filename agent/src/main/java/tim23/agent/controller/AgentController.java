package tim23.agent.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.DTO.RezervacijaDTO;
import tim23.agent.DTO.SobaDTO;
import tim23.agent.FromDTO.FromRezervacijaDTO;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Adresa;
import tim23.agent.model.Rezervacija;
import tim23.agent.model.Slika;
import tim23.agent.model.Soba;
import tim23.agent.model.TipSmestaja;
import tim23.agent.repository.AgentRepository;
import tim23.agent.repository.RezervacijaRepository;
import tim23.agent.repository.SlikaRepository;
import tim23.agent.service.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private JwtConfig tokenUtils;
	@Autowired
	public AgentService as;
	@Autowired
	public SlikaRepository sr;
	@Autowired
	private AgentRepository ar;
	@Autowired
	private RezervacijaRepository rr;
	
//	@PostMapping("/makingImage")
//	public void makeImage(@RequestBody Slika s) {
//		System.out.println("AAAAAAAAAAAAAAAAAAa");
//		System.out.println(s.getUrlSlike());
//		sr.save(s);
//	}

//	@GetMapping("/nadjiSobu")
//	   public Integer mojeRez(@RequestBody Soba soba) {
//		 return soba.getIdSoba();
//		 
//	 }
	
	@PostMapping("/realizacija/{id}")
	public ResponseEntity<?> makeImage(@PathVariable Integer id) {
		Rezervacija rez=rr.findByIdRezervacije(id);
		rez.setRealizovana(true);
		rr.save(rez);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	   @GetMapping("/mojeRez/{username}")
	   public ResponseEntity<?> mojeRez(@PathVariable String username) {
		   //System.out.println(username);
		   Integer id=as.findAgentByUsername(username);
		   //System.out.println(id);
//		   for(Rezervacija r:rr.findBySobaIdAgentaIdKorisnika(id)) {
//			   System.out.println(r.getIdRezervacije());
//		   }
		   return new ResponseEntity<>(rr.findBySobaIdAgentaIdKorisnika(id),HttpStatus.OK);
		   
	   }
	
//	   @GetMapping("/addRez")
//	   public ResponseEntity<?> addRez(RezervacijaDTO rezDTO) {
//		   FromRezervacijaDTO fr=new FromRezervacijaDTO(rezDTO);
//			Rezervacija nova=fr.convert();
//			as.addReservation(nova);
//			return new ResponseEntity<>(HttpStatus.OK);
//	   }

	   
	   @GetMapping("/uloga")
	   public boolean proveriUlogu(HttpServletRequest request) {
		   String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		   return ar.existsByUsername(username);
	   }
	
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
