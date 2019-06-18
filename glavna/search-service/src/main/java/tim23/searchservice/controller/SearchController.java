package tim23.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tim23.searchservice.config.JwtConfig;
import tim23.searchservice.dto.PonudaDTO;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private JwtConfig tokenUtils;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		//KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
		// ...

		return username;
	}
	
	@RequestMapping(
			value = "/getAllRooms",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> getAllRooms(@RequestBody PonudaDTO ponuda) {
		/*
		 * moja ideja je bila da preuzmem iz ponude koju sam poslala sa fronta datum dolaska i odlaska
		 * da iscitam iz rezervacije prvo sve sobe koje ne spadaju pod tim datumom.
		 * nakon sto iscitam sve sobe koje su dostupne u trazenom terminu, iz tabele sobe nadjem sve one
		 * koje se nalaze u tom gradu koji je trazen i koje primaju broj ljudi koji treba da dodje.
		 * kao povratnu vrednost na front treba vratiti listu soba koje su dotupne u obliku SobaDTO
		 * return se pise : return new ResponseEntity<>(listaSonaDTO,HTTPStatus.OK)
		 * i jos jedan komentar: ovde sam morala da stavim post metod iako je pravilno da ide get
		 * ali get sve salje preko linije zahteva i dosta je sjebao tu liniju zahteva, dodao joj je
		 * neke cudne karaktere i nije moglo da prodje, pa sam stavila post tako radi
		 */
		return null;
	}
}
