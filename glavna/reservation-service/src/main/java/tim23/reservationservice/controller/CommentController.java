package tim23.reservationservice.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tim23.reservationservice.config.JwtConfig;
import tim23.reservationservice.model.Komentar;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.repository.KomentarRepository;
import tim23.reservationservice.repository.ReservationRepository;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private KomentarRepository komentarRepository;
	
	@Autowired
	private JwtConfig tokenUtils;

	@PostMapping("/{idRez}")
	public ResponseEntity<Komentar> addComment(@RequestBody Komentar komentar, @PathVariable Integer idRez, HttpServletRequest req) {

		Optional<Rezervacija> rez = reservationRepository.findById(idRez);
		
		if (rez.isPresent()) {
			komentar.setRezervacija(rez.get());
			
			RestTemplate restTemplate = new RestTemplate();
			
			String fooResourceUrl
			  = "https://us-central1-tim23-245015.cloudfunctions.net/komentari";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Komentar> request = new HttpEntity<Komentar>(komentar, headers);
			ResponseEntity<String> response
			  = restTemplate.postForEntity(fooResourceUrl, request, String.class);
			
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("dozvoljena");
				String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(req));
				
				if (!komentarRepository.existsByRezervacija(komentar.getRezervacija())) {
				
					if (komentar.getRezervacija().getKrajnjiKorisnik().getUsername().equals(username)) {
						komentar.setOdobreno(false);
						Komentar retVal = komentarRepository.save(komentar);
						
						return ResponseEntity.ok(retVal);
					}
				}
			} else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
				System.out.println("nije dozvoljena");
			}
		}
		
		return ResponseEntity.badRequest().build();
	}
}
