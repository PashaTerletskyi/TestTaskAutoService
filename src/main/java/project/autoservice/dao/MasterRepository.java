package project.autoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.autoservice.model.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
}
