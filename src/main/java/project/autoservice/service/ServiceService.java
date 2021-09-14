package project.autoservice.service;

import project.autoservice.model.Service;

import java.util.List;

public interface ServiceService {
    Service create(Service service);

    Service update(Service service);

    Service findById(Long id);

    List<Service> getServicesById(List<Long> ids);
}
