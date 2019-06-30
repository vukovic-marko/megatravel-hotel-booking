package tim23.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.searchservice.model.Slika;

@Repository
public interface SlikaRepository extends JpaRepository<Slika, Integer>{

   public Slika findByIdSobe(Integer id);
}
