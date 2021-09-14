package project.autoservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MasterRequestDto {
    private String fullName;
    private List<Long> orderIds;
}