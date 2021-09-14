package project.autoservice.dto.response;

import lombok.Data;
import project.autoservice.model.Master;
import java.math.BigDecimal;

@Data
public class ServiceResponseDto {
    private Long id;
    private String name;
    private Master master;
    private BigDecimal price;
    private boolean status;
}
