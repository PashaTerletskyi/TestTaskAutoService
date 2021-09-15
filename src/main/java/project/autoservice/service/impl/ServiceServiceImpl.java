package project.autoservice.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import project.autoservice.dao.ServiceRepository;
import project.autoservice.model.Service;
import project.autoservice.service.ServiceService;

@Component
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service create(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service update(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.getById(id);
    }

    @Override
    public List<Service> getServicesById(List<Long> ids) {
        return serviceRepository.findAllById(ids);
    }
}
