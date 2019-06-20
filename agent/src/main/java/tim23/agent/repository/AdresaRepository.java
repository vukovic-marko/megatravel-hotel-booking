package tim23.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Adresa;

public interface AdresaRepository extends JpaRepository<Adresa, Integer>{
	public Adresa getById(Integer id);
}
