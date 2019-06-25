package tim23.agent.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Agent;
import tim23.agent.model.Soba;

public interface SobaRepository extends JpaRepository<Soba, Integer>{
	ArrayList<Soba> findByIdAgenta(Agent idAgenta);
}
