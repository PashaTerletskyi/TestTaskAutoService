package project.autoservice.dto.request;

import lombok.Data;

@Data
public class CarRequestDto {
    private String mark;
    private String model;
    private int year;
    private String number;
    private Long ownerId;
}
