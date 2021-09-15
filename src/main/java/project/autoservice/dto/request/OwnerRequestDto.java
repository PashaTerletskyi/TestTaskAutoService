package project.autoservice.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class OwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
