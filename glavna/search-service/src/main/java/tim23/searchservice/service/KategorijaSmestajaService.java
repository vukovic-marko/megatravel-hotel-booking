package tim23.searchservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.searchservice.model.KategorijaSmestaja;
import tim23.searchservice.repository.KategorijaSmestajaRepository;

@Service
public class KategorijaSmestajaService {

	@Autowired
	private KategorijaSmestajaRepository kategorijaRepository;
	
	public ArrayList<KategorijaSmestaja> getAll(){
		ArrayList<KategorijaSmestaja> kategorije = new ArrayList<KategorijaSmestaja>();
		kategorije = (ArrayList<KategorijaSmestaja>) kategorijaRepository.findAll();
		return kategorije;
	}
}
