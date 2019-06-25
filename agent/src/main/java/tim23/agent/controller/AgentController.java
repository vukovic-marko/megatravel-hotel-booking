package tim23.agent.controller;

import java.util.ArrayList;
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

import tim23.agent.AgentClient;
import tim23.agent.DTO.AgentoveSobeDTO;
import tim23.agent.DTO.SobaDTO;
import tim23.agent.FromDTO.FromSobaDTO;
import tim23.agent.FromDTO.SobaConverter;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.DodatneUsluge;
import tim23.agent.model.Rezervacija;
import tim23.agent.model.Soba;
import tim23.agent.model.SobeDodatneUsluge;
import tim23.agent.model.TipSmestaja;
import tim23.agent.model.poruke.GetSobaDodatnaUslugaResponse;
import tim23.agent.model.poruke.GetSobaResponse;
import tim23.agent.repository.AgentRepository;
import tim23.agent.repository.DodatneUslugeRepository;
import tim23.agent.repository.RezervacijaRepository;
import tim23.agent.repository.SobaDodatneUslugeRepository;
import tim23.agent.repository.SobaRepository;
//import tim23.agent.repository.SlikaRepository;
import tim23.agent.service.AgentService;
import tim23.agent.service.DodatneUslugeService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private JwtConfig tokenUtils;
	@Autowired
	public AgentService as;
//	@Autowired
//	public SyntheticRepository sr;
	@Autowired
	private AgentRepository ar;
	@Autowired
	private RezervacijaRepository rr;
	@Autowired
	private FromSobaDTO sobaConverter;
	@Autowired
	private SobaRepository sobaRepository;
	@Autowired
	private AgentClient client;
	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	@Autowired
	private DodatneUslugeService dodatneUslugeService;
	
	@Autowired
	private SobaConverter agentSobaConverter;
	
	@Autowired
	private SobaDodatneUslugeRepository sobaDodatnaUslugaRepository;
	
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
	
	@GetMapping("/getAllRooms")
	public ResponseEntity<?> getAllRooms(HttpServletRequest request){
		ArrayList<Soba> sobeAgentove = new ArrayList<Soba>();
		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		Agent agent = ar.findByUsername(username);
		sobeAgentove = sobaRepository.findByIdAgenta(agent);
		
		ArrayList<AgentoveSobeDTO> sobeZaFront = new ArrayList<AgentoveSobeDTO>();
		
		for(int i=0;i<sobeAgentove.size();i++) {
			AgentoveSobeDTO soba = agentSobaConverter.convert(sobeAgentove.get(i)); 
			ArrayList<SobeDodatneUsluge> uslugeZaSobu = sobaDodatnaUslugaRepository.findBySoba(sobeAgentove.get(i));
			for(int j=0;j<uslugeZaSobu.size();j++) {
				String usluga = uslugeZaSobu.get(i).getDodatnaUsluga().getNaziv();
				soba.getDodatneUsluge().add(usluga);		
			}
			sobeZaFront.add(soba);
		}
		return new ResponseEntity<>(sobeZaFront,HttpStatus.OK);
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
	
	@PostMapping("/getDodatneUsluge")
	public ResponseEntity<?> getDodatneUsluge(@RequestBody ArrayList<Integer> id){
		List<DodatneUsluge> usluge = dodatneUslugeService.getAll(id);
		return new ResponseEntity<>(usluge,HttpStatus.OK);
	}
	
	@PostMapping("/addRoom")
	public Soba addRoom(@RequestBody SobaDTO soba,HttpServletRequest request){
		//prvo pronaci sve dodatne usluge po id-u
		ArrayList<DodatneUsluge> dodatneUsluge = dodatneUslugeService.getAll(soba.getDodatneUsluge());
		Soba s = sobaConverter.convert(soba);
		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		Agent a = ar.findByUsername(username);
		s.setIdAgenta(a);
		GetSobaResponse response = client.getSoba(s);
		
		Soba nova = sobaRepository.save(response.getSoba());
		
		for(int i =0;i <dodatneUsluge.size();i++) {
			GetSobaDodatnaUslugaResponse dodata = client.getSobaDodatneUsluge(nova,dodatneUsluge.get(i));
			sobaDodatnaUslugaRepository.save(dodata.getSobeDodatnaUsluga());
		}
		
		return response.getSoba();
		
	}
	
	@GetMapping("/sveAdrese")
	public ResponseEntity<?> allAddresses(){
		//List<Adresa> lista=as.findAllAddresses();
//		for(Adresa a:lista) {
//			System.out.println(a.getGrad());
//		}
		return new ResponseEntity<>(as.findAllAddresses(),HttpStatus.OK);
	}

	@GetMapping("/getDodatneUsluge")
	public ResponseEntity<?> getDodatneUsluge(){
		return new ResponseEntity<>(dodatneUslugeRepository.findAll(),HttpStatus.OK);
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
