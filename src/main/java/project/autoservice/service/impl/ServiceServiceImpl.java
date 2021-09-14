package project.autoservice.service.impl;

import org.springframework.stereotype.Component;
import project.autoservice.dao.ServiceRepository;
import project.autoservice.model.Service;
import project.autoservice.service.ServiceService;

import java.util.List;

@Component
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public project.autoservice.model.Service create(project.autoservice.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public project.autoservice.model.Service update(project.autoservice.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public project.autoservice.model.Service findById(Long id) {
        return serviceRepository.getById(id);
    }

    @Override
    public List<Service> getServicesById(List<Long> ids) {
        return serviceRepository.findAllById(ids);
    }
}
