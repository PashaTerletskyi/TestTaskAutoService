package project.autoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.autoservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
