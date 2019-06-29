package tim23.hotelservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.hotelservice.model.Agent;
import tim23.hotelservice.model.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Integer>{
	List<Poruka> findByAgentPrimalac(Agent primalac);

}
