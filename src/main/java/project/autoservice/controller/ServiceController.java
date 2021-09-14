package project.autoservice.controller;

import org.springframework.web.bind.annotation.*;
import project.autoservice.dto.request.ServiceRequestDto;
import project.autoservice.dto.response.ServiceResponseDto;
import project.autoservice.model.Service;
import project.autoservice.service.ServiceService;
import project.autoservice.service.mapper.ServiceMapper;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;
    private final ServiceMapper serviceMapper;

    public ServiceController(ServiceService serviceService,
                             ServiceMapper serviceMapper) {
        this.serviceService = serviceService;
        this.serviceMapper = serviceMapper;
    }

    @PostMapping
    public ServiceResponseDto create(@RequestBody ServiceRequestDto requestDto) {
        Service service = serviceMapper.mapToModel(requestDto);
        serviceService.create(service);
        return serviceMapper.mapToDto(service);
    }

    @PutMapping("/{id}")
    public ServiceResponseDto update(@PathVariable Long id,
                                     @RequestBody ServiceRequestDto requestDto) {
        Service service = serviceMapper.mapToModel(requestDto);
        service.setId(id);
        serviceService.update(service);
        return serviceMapper.mapToDto(service);
    }

    @PutMapping("/{id}")
    public void updateStatus(@PathVariable Long id,
                             @RequestParam Boolean status) {
        Service service = serviceService.findById(id);
        service.setStatus(status);
        serviceService.update(service);
    }
}
