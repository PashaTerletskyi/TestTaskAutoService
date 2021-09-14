package project.autoservice.service.mapper;

import org.springframework.stereotype.Component;
import project.autoservice.dto.request.OwnerRequestDto;
import project.autoservice.model.Owner;
import project.autoservice.dto.response.OwnerResponseDto;
import project.autoservice.service.CarService;
import project.autoservice.service.OrderService;

@Component
public class OwnerMapper implements ResponseDtoMapper<OwnerResponseDto, Owner>,
        RequestDtoMapper<OwnerRequestDto, Owner> {
    private final CarService carService;
    private final OrderService orderService;

    public OwnerMapper(CarService carService, OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    @Override
    public OwnerResponseDto mapToDto(Owner owner) {
        OwnerResponseDto ownerResponseDto = new OwnerResponseDto();
        ownerResponseDto.setId(owner.getId());
        ownerResponseDto.setCars(owner.getCars());
        ownerResponseDto.setOrders(owner.getOrders());
        return ownerResponseDto;
    }

    @Override
    public Owner mapToModel(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setCars(carService.getCarsById(dto.getCarIds()));
        owner.setOrders(orderService.getOrdersById(dto.getCarIds()));
        return owner;
    }
}
