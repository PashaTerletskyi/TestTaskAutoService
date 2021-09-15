package project.autoservice.service.mapper;

import org.springframework.stereotype.Component;
import project.autoservice.dto.request.CarRequestDto;
import project.autoservice.dto.response.CarResponseDto;
import project.autoservice.model.Car;
import project.autoservice.model.Owner;
import project.autoservice.service.OwnerService;

@Component
public class CarMapper implements ResponseDtoMapper<CarResponseDto, Car>,
        RequestDtoMapper<CarRequestDto, Car> {
    private final OwnerService ownerService;

    public CarMapper(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public CarResponseDto mapToDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(car.getId());
        carResponseDto.setMark(car.getMark());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setYear(car.getYear());
        carResponseDto.setNumber(car.getNumber());
        carResponseDto.setOwner(car.getOwner());
        return carResponseDto;
    }

    @Override
    public Car mapToModel(CarRequestDto dto) {
        Car car = new Car();
        car.setMark(dto.getMark());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setNumber(dto.getNumber());
        Owner owner = ownerService.get(dto.getOwnerId());
        car.setOwner(owner);
        return car;
    }
}
