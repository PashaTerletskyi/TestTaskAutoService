package project.autoservice.service;

import java.util.List;
import project.autoservice.model.Car;

public interface CarService {
    Car create(Car car);

    Car update(Car car);

    List<Car> getCarsById(List<Long> ids);

    Car getCarById(Long id);
}
