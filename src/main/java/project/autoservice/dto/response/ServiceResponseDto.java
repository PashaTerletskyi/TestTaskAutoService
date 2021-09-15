package project.autoservice.dto.response;

import java.math.BigDecimal;
import lombok.Data;
import project.autoservice.model.Master;

@Data
public class ServiceResponseDto {
    private Long id;
    private String name;
    private Master master;
    private BigDecimal price;
    private boolean status;
}
