package project.autoservice.dto.response;

import lombok.Data;
import project.autoservice.model.Owner;

@Data
public class CarResponseDto {
    private Long id;
    private String mark;
    private String model;
    private int year;
    private String number;
    private Owner owner;
}
