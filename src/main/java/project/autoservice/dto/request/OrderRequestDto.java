package project.autoservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import project.autoservice.model.Order;

@Data
public class OrderRequestDto {
    private Long carId;
    private String problemDescription;
    private LocalDateTime orderTimeStart;
    private List<Long> serviceIds;
    private List<Long> productsIds;
    private Order.Status status;
    private BigDecimal finalPrice;
    private LocalDateTime orderTimeFinish;
}
