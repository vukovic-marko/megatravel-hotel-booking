package tim23.searchservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.searchservice.model.TipSmestaja;
import tim23.searchservice.repository.TipSmestajaRepository;

@Service
public class TipSmestajaService {

	@Autowired
	private TipSmestajaRepository tipSmestajaRepository;
	
	public ArrayList<TipSmestaja> getAll(){
		ArrayList<TipSmestaja> tipovi = new ArrayList<TipSmestaja>();
		tipovi = (ArrayList<TipSmestaja>) tipSmestajaRepository.findAll();
		return tipovi;
	}
}
