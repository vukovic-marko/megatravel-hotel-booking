package tim23.hotelservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.hotelservice.model.Soba;
import tim23.hotelservice.repository.SobaRepository;

@Service
public class SobaService {

	@Autowired
	private SobaRepository sobaRepository;
	
	public Soba get(Integer id) {
		List<Soba> lista= sobaRepository.findAll();
		Soba trazena = new Soba();
		
		for(int i=0;i<lista.size();i++) {
			if(id == lista.get(i).getIdSoba()) {
				trazena = lista.get(i);
				break;
			}
		}
		return trazena;
	}
}
