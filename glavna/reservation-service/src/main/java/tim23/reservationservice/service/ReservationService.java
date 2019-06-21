package tim23.reservationservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.model.Soba;
import tim23.reservationservice.repository.ReservationRepository;
import tim23.reservationservice.repository.SobaRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository rr;
	@Autowired
	private SobaRepository sr;

	
	public List<Rezervacija> returnReservationByRoomId(Integer id) {

		List<Rezervacija> lista=rr.findBySobaIdSoba(id);
//		for(Rezervacija lr: lista) {
//			System.out.println(lr.getIdRezervacije());
//		}
		return lista;
	}
	
	public void addReservation(Rezervacija rez) {
		rr.save(rez);
	}

	public boolean CheckIfRoomIsFree(Date dolazak,Date odlazak,Integer id) {
		List<Rezervacija> lista=returnReservationByRoomId(id);
        boolean los=true;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//Date date1 = sdf.parse("2015-12-23");
		        //Date date2 = sdf.parse("2015-12-28");
		        for(Rezervacija r : lista) {
		        	if((dolazak.compareTo(r.getDatumOdlaska())>0 && odlazak.compareTo(r.getDatumOdlaska())>0 && dolazak.compareTo(r.getDatumDolaska())>0 && odlazak.compareTo(r.getDatumDolaska())>0)) { //date1 je posle rezervisanog odlaska
		        		
		        	}
		        	else if(dolazak.compareTo(r.getDatumOdlaska())<0 && odlazak.compareTo(r.getDatumOdlaska())<0  && dolazak.compareTo(r.getDatumDolaska())<0 && odlazak.compareTo(r.getDatumDolaska())<0) {
		        		
		        	}else {
		        		los=false;
		        	}
		        }

	       return los;
	}
	
	public Soba findRoomById(Integer id) {
		return sr.findByIdSoba(id);
	}
}
