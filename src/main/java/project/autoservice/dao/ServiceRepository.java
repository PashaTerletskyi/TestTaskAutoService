package project.autoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.autoservice.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
