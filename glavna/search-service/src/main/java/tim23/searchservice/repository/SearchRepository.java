package tim23.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.searchservice.model.Soba;
@Repository
public interface SearchRepository extends JpaRepository<Soba, Integer>{
	
	public Soba getByIdSoba(Integer bs);

}
