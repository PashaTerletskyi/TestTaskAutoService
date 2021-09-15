package project.autoservice.service;

import java.util.List;
import project.autoservice.model.Service;

public interface ServiceService {
    Service create(Service service);

    Service update(Service service);

    Service findById(Long id);

    List<Service> getServicesById(List<Long> ids);
}
