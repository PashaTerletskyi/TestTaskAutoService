package project.autoservice.controller;

import org.springframework.web.bind.annotation.*;
import project.autoservice.dto.request.CarRequestDto;
import project.autoservice.dto.response.CarResponseDto;
import project.autoservice.model.Car;
import project.autoservice.service.CarService;
import project.autoservice.service.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public CarResponseDto create(@RequestBody CarRequestDto requestDto) {
        Car car = carMapper.mapToModel(requestDto);
        carService.create(car);
        return carMapper.mapToDto(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@PathVariable Long id,
                                 @RequestBody CarRequestDto requestDto) {
        Car car = carMapper.mapToModel(requestDto);
        car.setId(id);
        carService.update(car);
        return carMapper.mapToDto(car);
    }
}
