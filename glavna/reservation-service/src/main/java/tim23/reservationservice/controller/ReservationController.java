package tim23.reservationservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.reservationservice.config.JwtConfig;
import tim23.reservationservice.model.Soba;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private JwtConfig tokenUtils;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		// KrajnjiKorisnik k = krajnjiKorisnikRepository.getByUsername(krajnjiKorisnik);
		// ...

		return username;
	}
	
	@PostMapping("/")
	public void makeAReservation(/*ReservationDTO reservation*/ Soba soba, Date datumDolaska, Date datumOdlaska) {
		//	TODO: implement making a reservation
		// 
		//	reservationRepository.save(reservation);
	}
}
