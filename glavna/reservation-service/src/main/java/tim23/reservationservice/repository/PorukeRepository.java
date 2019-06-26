package tim23.reservationservice.repository;

import java.util.List;


import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tim23.reservationservice.model.*;
@Repository
public interface PorukeRepository extends JpaRepository<Poruka, Integer>{
	@org.springframework.data.jpa.repository.Query(value = "select * from Poruka p left outer join KrajnjiKorisnik kk on kk.idKorisnika = p.klijentPrimalac  where kk.username = ?1",nativeQuery=true )
	public List<Poruka> getByKlijentPrimalac(String username);

	

}
