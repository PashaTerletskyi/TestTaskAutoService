package project.autoservice.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import project.autoservice.dao.MasterRepository;
import project.autoservice.model.Master;
import project.autoservice.model.Order;
import project.autoservice.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
    private static int ONE_HUNDRED = 100;
    private static int FORTY = 40;
    private MasterRepository masterRepository;

    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Master create(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master findById(Long id) {
        return masterRepository.getById(id);
    }

    @Override
    public List<Order> getMasterOrdersById(Long id) {
        Master master = masterRepository.getById(id);
        return master.getOrders();
    }

    @Override
    public List<Order> getMasterOrders(Long id) {
        Master master = masterRepository.getById(id);
        return master.getOrders();
    }

    @Override
    public BigDecimal getMasterSalaryById(Long id) {
        Master master = masterRepository.getById(id);
        BigDecimal masterCost = master.getOrders()
                .stream()
                .map(Order::getFinalPrice)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return masterCost.multiply(BigDecimal.valueOf(FORTY))
                .divide(BigDecimal.valueOf(ONE_HUNDRED));
    }
}
