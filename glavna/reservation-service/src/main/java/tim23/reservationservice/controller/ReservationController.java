package tim23.reservationservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.reservationservice.DTO.RezervacijaDTO;
import tim23.reservationservice.config.JwtConfig;
import tim23.reservationservice.converterFromDTO.FromRezervacijaDTO;
import tim23.reservationservice.model.Agent;
import tim23.reservationservice.model.KrajnjiKorisnik;
import tim23.reservationservice.model.Poruka;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.repository.PorukeRepository;
import tim23.reservationservice.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private JwtConfig tokenUtils;
	@Autowired
	private ReservationService rs;
	@Autowired
	private PorukeRepository pr;
	
	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		// KrajnjiKorisnik k = krajnjiKorisnikRepository.getByUsername(krajnjiKorisnik);
		// ...

		return username;
	}
	
	@GetMapping("/poruke/{username}")
		public ResponseEntity<?>getMessages(@PathVariable String username){
			List<Poruka> poruke = rs.getPoruke(username);
			
		if(poruke==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
		
			for(int i=0;i<poruke.size();i++)
				System.out.println(poruke.get(i).getSadrzaj());
			return new ResponseEntity<>(poruke, HttpStatus.OK);
		
		}
		}
	
	@GetMapping("/soba/{idSobe}")
	public ResponseEntity<?> rate(@PathVariable Integer idSobe){
		 Double ocena = rs.ocenaSobe(idSobe);
		 if(ocena == null)
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 else
			 return new ResponseEntity<>(ocena,HttpStatus.OK);
	}
	
	@PostMapping("/add/{idAgentaPrimaoca},{sadrzaj}")
	public void sendM(@PathVariable Integer idAgentaPrimaoca,@PathVariable String sadrzaj,HttpServletRequest request){
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);
		KrajnjiKorisnik k = rs.getByUsername(username);
		Agent agent = rs.getAgent(idAgentaPrimaoca);
		Poruka poruka = new Poruka();
		poruka.setAgentPrimalac(agent);
		poruka.setKlijentPosiljalac(k);
		poruka.setSadrzaj(sadrzaj);
		rs.sacuvaj(poruka);
		
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
