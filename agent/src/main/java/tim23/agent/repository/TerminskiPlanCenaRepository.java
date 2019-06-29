package tim23.agent.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Cena;
import tim23.agent.model.Soba;

public interface TerminskiPlanCenaRepository extends JpaRepository<Cena, Integer>{
	ArrayList<Cena> findBySoba(Soba idSobe);
}
