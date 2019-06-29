package tim23.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.searchservice.model.KrajnjiKorisnik;
import tim23.searchservice.model.Uloga;
import tim23.searchservice.repository.KrajnjiKorisnikRepository;

@RestController
@RequestMapping("/registracija")
public class RegistracijaController {
	
	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	@PostMapping("/registruj")
	public void registracija(@RequestBody KrajnjiKorisnik korisnik) {
		korisnik.setBlokiran(false);
		korisnik.setUklonjen(false);
		korisnik.setUloga(Uloga.KLIJENT);
		krajnjiKorisnikRepository.save(korisnik);
	}

}
