package project.autoservice.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ServiceRequestDto {
    private String name;
    private Long masterId;
    private BigDecimal price;
    private boolean status;
}
