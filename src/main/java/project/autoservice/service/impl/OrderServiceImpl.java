package project.autoservice.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import project.autoservice.dao.OrderRepository;
import project.autoservice.model.Order;
import project.autoservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getOrdersById(List<Long> ids) {
        return orderRepository.findAllById(ids);
    }

    @Override
    public BigDecimal getCostById(Long id) {
        Order order = orderRepository.findById(id).get();
        /*
            TO DO Business logic
         */
        return order.getFinalPrice();
    }
}
