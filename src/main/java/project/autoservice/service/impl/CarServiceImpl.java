package project.autoservice.service.impl;

import org.springframework.stereotype.Service;
import project.autoservice.dao.CarRepository;
import project.autoservice.model.Car;
import project.autoservice.service.CarService;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCarsById(List<Long> ids) {
        return carRepository.findAllById(ids);
    }

    @Override
    public Car getCarById(Long id) {
        return  carRepository.findById(id).get();
    }
}
