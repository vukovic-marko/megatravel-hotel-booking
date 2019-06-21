package tim23.reservationservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.reservationservice.DTO.RezervacijaDTO;
import tim23.reservationservice.config.JwtConfig;
import tim23.reservationservice.converterFromDTO.FromRezervacijaDTO;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.service.ReservationService;

@RestController
@RequestMapping("/reservation")
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
	
	@PostMapping("/addReservation")
	public ResponseEntity<?> makeAReservation(RezervacijaDTO reservation) {
		//	TODO: implement making a reservation
		boolean slobodna=rs.CheckIfRoomIsFree(reservation.getDatumDolaska(), reservation.getDatumOdlaska(), reservation.getIdRezervacije());
		if(slobodna) {
			FromRezervacijaDTO fr=new FromRezervacijaDTO(reservation);
			Rezervacija nova=fr.convert();
			rs.addReservation(nova);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
}
