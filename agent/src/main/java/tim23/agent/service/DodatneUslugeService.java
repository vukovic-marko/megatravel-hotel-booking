package tim23.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.agent.model.DodatneUsluge;
import tim23.agent.repository.DodatneUslugeRepository;

@Service
public class DodatneUslugeService {

	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	public ArrayList<DodatneUsluge> getAll(ArrayList<Integer> lista){
		List<DodatneUsluge> dodatneUsluge = dodatneUslugeRepository.findAll(); 
		ArrayList<DodatneUsluge> usluge = new ArrayList<DodatneUsluge>();
		for(int i=0;i<lista.size();i++) {
			for(int j=0;j<dodatneUsluge.size();j++) {
				if(lista.get(i) == dodatneUsluge.get(j).getId()) {
					usluge.add(dodatneUsluge.get(j));
				}
			}
		}
		return usluge;
	}
}
