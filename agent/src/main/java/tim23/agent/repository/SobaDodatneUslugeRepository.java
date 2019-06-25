package tim23.agent.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Soba;
import tim23.agent.model.SobeDodatneUsluge;

public interface SobaDodatneUslugeRepository extends JpaRepository<SobeDodatneUsluge, Integer>{
	ArrayList<SobeDodatneUsluge> findBySoba(Soba soba);
}
