package tim23.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.KategorijaSmestaja;

public interface KategorijeRepository extends JpaRepository<KategorijaSmestaja, Integer>{
	public KategorijaSmestaja findByNaziv(String naziv);
}
