package project.autoservice.service.mapper;

import org.springframework.stereotype.Component;
import project.autoservice.dto.request.ServiceRequestDto;
import project.autoservice.dto.response.ServiceResponseDto;
import project.autoservice.model.Service;
import project.autoservice.service.MasterService;

@Component
public class ServiceMapper implements ResponseDtoMapper<ServiceResponseDto, Service>,
        RequestDtoMapper<ServiceRequestDto, Service> {
    private final MasterService masterService;

    public ServiceMapper(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public ServiceResponseDto mapToDto(Service service) {
        ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
        serviceResponseDto.setId(service.getId());
        serviceResponseDto.setName(service.getName());
        serviceResponseDto.setMaster(service.getMaster());
        serviceResponseDto.setPrice(service.getPrice());
        serviceResponseDto.setStatus(service.isStatus());
        return serviceResponseDto;
    }

    @Override
    public Service mapToModel(ServiceRequestDto dto) {
        Service service = new Service();
        service.setName(dto.getName());
        service.setMaster(masterService.findById(dto.getMasterId()));
        service.setPrice(dto.getPrice());
        service.setStatus(dto.isStatus());
        return service;
    }
}
