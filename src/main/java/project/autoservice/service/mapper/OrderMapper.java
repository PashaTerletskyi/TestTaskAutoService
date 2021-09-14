package project.autoservice.service.mapper;

import org.springframework.stereotype.Component;
import project.autoservice.dto.request.OrderRequestDto;
import project.autoservice.model.Car;
import project.autoservice.model.Order;
import project.autoservice.dto.response.OrderResponseDto;
import project.autoservice.service.CarService;
import project.autoservice.service.ProductService;
import project.autoservice.service.ServiceService;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order>,
        RequestDtoMapper<OrderRequestDto, Order> {
    private final CarService carService;
    private final ServiceService serviceService;
    private final ProductService productService;

    public OrderMapper(CarService carService,
                       ServiceService serviceService,
                       ProductService productService) {
        this.carService = carService;
        this.serviceService = serviceService;
        this.productService = productService;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setCar(order.getCar());
        orderResponseDto.setProblemDescription(order.getProblemDescription());
        orderResponseDto.setOrderTimeStart(order.getOrderTimeStart());
        orderResponseDto.setServices(order.getServices());
        orderResponseDto.setProducts(order.getProducts());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setFinalPrice(order.getFinalPrice());
        orderResponseDto.setOrderTimeFinish(order.getOrderTimeFinish());
        return orderResponseDto;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        Car car = carService.getCarById(dto.getCarId());
        order.setCar(car);
        order.setProblemDescription(dto.getProblemDescription());
        order.setOrderTimeStart(dto.getOrderTimeStart());
        order.setServices(serviceService.getServicesById(dto.getServiceIds()));
        order.setProducts(productService.getProductById(dto.getProductsIds()));
        order.setStatus(dto.getStatus());
        order.setFinalPrice(dto.getFinalPrice());
        order.setOrderTimeFinish(dto.getOrderTimeFinish());
        return null;
    }
}
