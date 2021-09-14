package project.autoservice.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ServiceRequestDto {
    private String name;
    private Long masterId;
    private BigDecimal price;
    private boolean status;
}
