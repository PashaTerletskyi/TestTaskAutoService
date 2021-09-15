package project.autoservice.service;

import java.math.BigDecimal;
import java.util.List;
import project.autoservice.model.Order;

public interface OrderService {
    Order create(Order order);

    Order update(Order order);

    Order getById(Long id);

    List<Order> getOrdersById(List<Long> ids);

    BigDecimal getCostById(Long id);
}
