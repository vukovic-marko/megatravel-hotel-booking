package tim23.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.TipSmestaja;

public interface TipSmestajaRepository extends JpaRepository<TipSmestaja, Integer>{
	public TipSmestaja getByIdTipa(Integer id);
	public TipSmestaja findByNaziv(String naziv);
}
