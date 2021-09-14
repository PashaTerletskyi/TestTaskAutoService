package project.autoservice.service;

import project.autoservice.model.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car update(Car car);

    List<Car> getCarsById(List<Long> ids);

    Car getCarById(Long id);
}
