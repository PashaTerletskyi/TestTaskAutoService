package project.autoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.autoservice.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
