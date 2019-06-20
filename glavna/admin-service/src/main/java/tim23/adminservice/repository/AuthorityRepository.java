package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority getByName(String name);
}
