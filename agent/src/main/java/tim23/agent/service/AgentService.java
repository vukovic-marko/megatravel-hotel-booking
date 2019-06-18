package tim23.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.agent.model.Adresa;
import tim23.agent.model.TipSmestaja;
import tim23.agent.repository.AdresaRepository;
import tim23.agent.repository.TipSmestajaRepository;

@Service
public class AgentService {
	@Autowired
	public TipSmestajaRepository tsr;
	@Autowired
	public AdresaRepository ar;
	public List<TipSmestaja> findAllTypesOfRooms() {
		return tsr.findAll();
	}

	public List<Adresa> findAllAddresses() {
		return ar.findAll();
	}
}
