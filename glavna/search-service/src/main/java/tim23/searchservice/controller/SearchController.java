package tim23.searchservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tim23.searchservice.config.JwtConfig;
import tim23.searchservice.dto.DodatneUslugeDTO;
import tim23.searchservice.dto.KategorijaSmestajaDTO;
import tim23.searchservice.dto.PonudaDTO;
import tim23.searchservice.dto.TipSmestajaDTO;
import tim23.searchservice.model.DodatneUsluge;
import tim23.searchservice.model.KategorijaSmestaja;
import tim23.searchservice.model.Soba;
import tim23.searchservice.model.TipSmestaja;
import tim23.searchservice.repository.KrajnjiKorisnikRepository;
import tim23.searchservice.service.DodatneUslugeService;
import tim23.searchservice.service.KategorijaSmestajaService;
import tim23.searchservice.service.TipSmestajaService;
import tim23.searchservice.*;
@RestController
@RequestMapping("/search")
public class SearchController {
 private   static ArrayList<String> usluge = new ArrayList<>();
	@Autowired
	private JwtConfig tokenUtils;
	@Autowired
	private DodatneUslugeService dodatneUslugeService;
	@Autowired SearchService searchService;
	@Autowired
	private TipSmestajaService tipSmestajaService;
	@Autowired
	private KategorijaSmestajaService kategorijaService;

	@GetMapping("/slika/{id}")
	public ResponseEntity<?>nadjiS(@PathVariable Integer id){
		return new ResponseEntity<>(searchService.getSlika(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		//KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
		// ...

		return username;
	}
	
	@RequestMapping(
			value = "/getAllDodatneUsluge",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getDodatneUsluge() {
		ArrayList<DodatneUslugeDTO> uslugeZaFront = new ArrayList<DodatneUslugeDTO>();
		ArrayList<DodatneUsluge> usluge = dodatneUslugeService.getAll();
		for(int i=0;i<usluge.size();i++) {
			DodatneUslugeDTO dodUsl = new DodatneUslugeDTO();
			dodUsl.setId(usluge.get(i).getId());
			dodUsl.setNaziv(usluge.get(i).getNaziv());
			uslugeZaFront.add(dodUsl);
		}
		return new ResponseEntity<>(uslugeZaFront,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getAllTipoviSmestaja",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getTipoviSmestaja() {
		ArrayList<TipSmestajaDTO> smestajiZaFront = new ArrayList<TipSmestajaDTO>();
		ArrayList<TipSmestaja> tipovi = tipSmestajaService.getAll();
		for(int i=0;i<tipovi.size();i++) {
			TipSmestajaDTO dodUsl = new TipSmestajaDTO();
			dodUsl.setId(tipovi.get(i).getIdTipa());
			dodUsl.setNaziv(tipovi.get(i).getNaziv());
			smestajiZaFront.add(dodUsl);
		}
		return new ResponseEntity<>(smestajiZaFront,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getAllKategorije",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getKategorije() {
		ArrayList<KategorijaSmestajaDTO> kategorijeZaFront = new ArrayList<KategorijaSmestajaDTO>();
		ArrayList<KategorijaSmestaja> kat = kategorijaService.getAll();
		for(int i=0;i<kat.size();i++) {
			KategorijaSmestajaDTO kategorija = new KategorijaSmestajaDTO();
			kategorija.setId(kat.get(i).getId());
			kategorija.setNaziv(kat.get(i).getNaziv());
			kategorijeZaFront.add(kategorija);
		}
		return new ResponseEntity<>(kategorijeZaFront,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getAllRooms",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> getAllRooms(@RequestBody PonudaDTO ponuda) {
		PonudaDTO p = ponuda;
		usluge = p.getNazivDodatneUsluge();
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
		return new ResponseEntity<>(HttpStatus.OK);
	}
	   @GetMapping("/{brojkreveta},{grad},{dd},{dod},{tip},{kat}")
	    public ResponseEntity<?> search(@PathVariable String brojkreveta, @PathVariable String grad,@PathVariable String dd,@PathVariable String dod,@PathVariable String tip,@PathVariable String kat) throws java.text.ParseException {
	  String dateP = dd.replaceAll("_", "/");
	  String dateK = dod.replaceAll("_", "/");
	
	 
		   List<Soba> s = searchService.fuzzySearch(brojkreveta,grad,dateP,dateK,tip,kat,usluge);
	     
	    	 return new ResponseEntity<>(s, HttpStatus.OK);
	    	 
	   }

	   
	   @Autowired
	   private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	   
	   @GetMapping("/uloga")
	   public boolean proveriUlogu(HttpServletRequest request) {
		   String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		   return krajnjiKorisnikRepository.existsByUsername(username);
	   }
}
