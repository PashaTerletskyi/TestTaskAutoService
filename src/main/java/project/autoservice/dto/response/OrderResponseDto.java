package project.autoservice.dto.response;

import lombok.Data;
import project.autoservice.model.Car;
import project.autoservice.model.Order;
import project.autoservice.model.Product;
import project.autoservice.model.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private Car car;
    private String problemDescription;
    private LocalDateTime orderTimeStart;
    private List<Service> services;
    private List<Product> products;
    private Order.Status status;
    private BigDecimal finalPrice;
    private LocalDateTime orderTimeFinish;
}
