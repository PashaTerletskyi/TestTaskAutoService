package project.autoservice.dto.response;

import java.util.List;
import lombok.Data;
import project.autoservice.model.Order;

@Data
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Order> orders;
}
