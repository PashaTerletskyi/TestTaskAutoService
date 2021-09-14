package project.autoservice.dto.response;

import lombok.Data;
import project.autoservice.model.Car;
import project.autoservice.model.Order;
import java.util.List;

@Data
public class OwnerResponseDto {
    private Long id;
    private List<Car> cars;
    private List<Order> orders;
}
