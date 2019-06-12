package tim23.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.authservice.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	Administrator findOneByUsername(String username);
}
