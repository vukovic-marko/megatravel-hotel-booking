package tim23.searchservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.searchservice.model.DodatneUsluge;
import tim23.searchservice.repository.DodatneUslugeRepository;

@Service
public class DodatneUslugeService {

	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	public ArrayList<DodatneUsluge> getAll(){
		ArrayList<DodatneUsluge> usluge = (ArrayList<DodatneUsluge>) dodatneUslugeRepository.findAll();
		return usluge;
	}
}
