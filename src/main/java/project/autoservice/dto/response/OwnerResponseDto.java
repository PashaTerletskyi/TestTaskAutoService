package project.autoservice.dto.response;

import java.util.List;
import lombok.Data;
import project.autoservice.model.Car;
import project.autoservice.model.Order;

@Data
public class OwnerResponseDto {
    private Long id;
    private List<Car> cars;
    private List<Order> orders;
}
