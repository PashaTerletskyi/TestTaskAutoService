package project.autoservice.service;

import java.math.BigDecimal;
import java.util.List;
import project.autoservice.model.Master;
import project.autoservice.model.Order;

public interface MasterService {
    Master create(Master master);

    Master update(Master master);

    Master findById(Long id);

    List<Order> getMasterOrdersById(Long id);

    List<Order> getMasterOrders(Long id);

    BigDecimal getMasterSalaryById(Long id);
}
