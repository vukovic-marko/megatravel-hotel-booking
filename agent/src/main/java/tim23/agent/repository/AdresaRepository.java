package tim23.agent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Adresa;

public interface AdresaRepository extends JpaRepository<Adresa, Integer>{
}
