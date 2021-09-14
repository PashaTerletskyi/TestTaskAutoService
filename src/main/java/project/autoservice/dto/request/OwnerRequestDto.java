package project.autoservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
