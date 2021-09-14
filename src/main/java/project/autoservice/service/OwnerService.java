package project.autoservice.service;

import project.autoservice.model.Owner;

public interface OwnerService {
    Owner create(Owner owner);

    Owner update(Owner owner);

    Owner get(Long id);
}
