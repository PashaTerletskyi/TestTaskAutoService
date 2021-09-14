package project.autoservice.service.impl;

import org.springframework.stereotype.Service;
import project.autoservice.dao.OwnerRepository;
import project.autoservice.model.Owner;
import project.autoservice.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner get(Long id) {
        return ownerRepository.getById(id);
    }
}
