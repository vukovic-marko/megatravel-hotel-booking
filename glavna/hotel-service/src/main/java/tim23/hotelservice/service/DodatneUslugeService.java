package tim23.hotelservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.hotelservice.model.DodatneUsluge;
import tim23.hotelservice.repository.DodatneUslugeRepository;

@Service
public class DodatneUslugeService {

	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	public DodatneUsluge get(Integer id) {
		List<DodatneUsluge> usluge = dodatneUslugeRepository.findAll();
		DodatneUsluge trazena = new DodatneUsluge();
		for(int i=0;i<usluge.size();i++) {
			if(id == usluge.get(i).getId()) {
				trazena = usluge.get(i);
				break;
			}
		}
		
		return trazena;
	}
}
