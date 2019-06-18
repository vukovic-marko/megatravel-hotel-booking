package tim23.reservationservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.reservationservice.DTO.RezervacijaDTO;
import tim23.reservationservice.config.JwtConfig;
import tim23.reservationservice.converterFromDTO.FromRezervacijaDTO;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private ReservationService rs;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		// KrajnjiKorisnik k = krajnjiKorisnikRepository.getByUsername(krajnjiKorisnik);
		// ...

		return username;
	}
	
	@GetMapping("/rezervisi")
	public ResponseEntity<?> makeAReservation(RezervacijaDTO rez) {
		boolean slobodan=rs.CheckIfRoomIsFree(rez.getDatumDolaska(),rez.getDatumOdlaska(),rez.getSoba().getIdSoba());
		//System.out.println(rs.CheckIfRoomIsFree());
		if(slobodan) {
			Rezervacija zaDodavanje=new Rezervacija();
			FromRezervacijaDTO fr=new FromRezervacijaDTO(rez);
			zaDodavanje=fr.convert();
			rs.addReservation(zaDodavanje);
			return new ResponseEntity<>( HttpStatus.OK);
		}else {
			////////////////////////////////////napraviti za ovo na frontu neku foru
			return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
}
