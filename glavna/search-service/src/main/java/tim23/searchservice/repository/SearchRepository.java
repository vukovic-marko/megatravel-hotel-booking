package tim23.searchservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tim23.searchservice.model.Soba;

public interface SearchRepository extends JpaRepository<Soba, Integer>{
	
	public Soba getByidSoba(int bs);

}
