package project.autoservice.service;

import project.autoservice.model.Master;
import project.autoservice.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface MasterService {
    Master create(Master master);

    Master update(Master master);

    Master findById(Long id);

    List<Order> getMasterOrdersById(Long id);

    List<Order> getMasterOrders(Long id);

    BigDecimal getMasterSalaryById(Long id);
}
