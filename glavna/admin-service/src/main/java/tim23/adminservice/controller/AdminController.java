package tim23.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import tim23.adminservice.config.JwtConfig;
import tim23.adminservice.model.*;
import tim23.adminservice.repository.AdministratorRepository;
import tim23.adminservice.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private JwtConfig tokenUtils;

	@Autowired
	private AgentService agentService;

	@Autowired
	private KrajnjiKorisnikService krajnjiKorisnikService;

	@Autowired
	private KomentarService komentarService;

	@Autowired
	private TipSmestajaService tipSmestajaService;

	@Autowired
	private KategorijaSmestajaService kategorijaSmestajaService;

	@PostMapping("/register")
	public ResponseEntity<Agent> registerAgent(@RequestBody Agent agent, HttpServletRequest request) {
		return agentService.registerAgent(agent);
	}

	@GetMapping("/korisnik")
	public ResponseEntity<List<KrajnjiKorisnik>> getKrajnjiKorisnici() {
		return ResponseEntity.ok(krajnjiKorisnikService.getKrajnjiKorisnici());
	}

	@GetMapping("/korisnik/{username}")
	public ResponseEntity<KrajnjiKorisnik> getKrajnjiKorisnik(@PathVariable String username) {
		return krajnjiKorisnikService.getKrajnjiKorisnik(username);
	}

	@PostMapping("/korisnik/{username}/block/{blokiran}")
	public ResponseEntity<KrajnjiKorisnik> setBlokiran(@PathVariable String username, @PathVariable Boolean blokiran) {
		return krajnjiKorisnikService.setBlokiran(username, blokiran);
	}

	@DeleteMapping("/korisnik/{username}/delete/{uklonjen}")
	public ResponseEntity setUklonjen(@PathVariable String username, @PathVariable Boolean uklonjen) {
		return krajnjiKorisnikService.setUklonjen(username, uklonjen);
	}



	@GetMapping("/komentar")
	public ResponseEntity<List<Komentar>> getKomentari() {
		return komentarService.getKomentari();
	}

	@GetMapping("/komentar/{id}")
	public ResponseEntity<Komentar> getKomentar(@PathVariable Integer id) {
		return komentarService.getKomentar(id);
	}

	@PostMapping("/komentar/{id}")
	public ResponseEntity<Komentar> objaviKomentar(@PathVariable Integer id) {
		return komentarService.objaviKomentar(id);
	}



	@GetMapping("/tipSmestaja")
	public ResponseEntity<List<TipSmestaja>> getTipoviSmestaja() {
		return tipSmestajaService.getTipoviSmestaja();
	}

	@GetMapping("/tipSmestaja/{id}")
	public ResponseEntity<TipSmestaja> getTipSmestaja(@PathVariable Integer id) {
		return tipSmestajaService.getTipSmestaja(id);
	}

	@PostMapping("/tipSmestaja")
	public ResponseEntity<TipSmestaja> dodajTipSmestaja(@RequestBody TipSmestaja tipSmestaja) {
		return tipSmestajaService.dodajTipSmestaja(tipSmestaja);
	}

	@DeleteMapping("/tipSmestaja/{id}")
	public ResponseEntity ukloniTipSmestaja(@PathVariable Integer id) {
		return tipSmestajaService.ukloniTipSmestaja(id);
	}



	@GetMapping("/kategorijaSmestaja")
	public ResponseEntity<List<KategorijaSmestaja>> getKategorijeSmestaja() {
		return kategorijaSmestajaService.getKategotijeSmestaja();
	}

	@PostMapping("/kategorijaSmestaja")
	public ResponseEntity<KategorijaSmestaja> dodajKategorijuSmestaja(@RequestBody KategorijaSmestaja kategorijaSmestaja) {
		return kategorijaSmestajaService.dodajKategorijuSmestaja(kategorijaSmestaja);
	}

	@DeleteMapping("/kategorijaSmestaja/{id}")
	public ResponseEntity ukloniKategorijuSmestaja(@PathVariable Integer id) {
		return kategorijaSmestajaService.ukloniKategorijuSmestaja(id);
	}

	//----------------------------------------------
	// TEST
	//----------------------------------------------

//	@Autowired
//	private AdministratorRepository administratorRepository;
//
//	@GetMapping("/")
//	public Administrator hello(HttpServletRequest request) {
//
//		System.out.println("pogodjen");
//
//		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
//
//		Administrator a = administratorRepository.findByUsername(username);
//
//		return a;
//	}
}
