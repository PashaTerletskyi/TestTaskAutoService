package project.autoservice.dto.response;

import lombok.Data;
import project.autoservice.model.Order;
import java.util.List;

@Data
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Order> orders;
}
