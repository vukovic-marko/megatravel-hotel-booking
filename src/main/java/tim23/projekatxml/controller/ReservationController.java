package tim23.projekatxml.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.entiteti.Soba;

@RestController
public class ReservationController {
	
	@PostMapping("/reservation")
	public void makeAReservation(/*ReservationDTO reservation*/ Soba soba, Date datumDolaska, Date datumOdlaska) {
		//	TODO: implement making a reservation
		// 
		//	reservationRepository.save(reservation);
	}
}
