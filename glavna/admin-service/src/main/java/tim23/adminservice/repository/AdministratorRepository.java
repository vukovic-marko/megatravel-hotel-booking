package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Administrator findByUsername(String username);
}
