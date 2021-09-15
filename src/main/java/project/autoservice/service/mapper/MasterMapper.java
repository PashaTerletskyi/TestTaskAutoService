package project.autoservice.service.mapper;

import org.springframework.stereotype.Component;
import project.autoservice.dto.request.MasterRequestDto;
import project.autoservice.dto.response.MasterResponseDto;
import project.autoservice.model.Master;
import project.autoservice.service.OrderService;

@Component
public class MasterMapper implements ResponseDtoMapper<MasterResponseDto, Master>,
        RequestDtoMapper<MasterRequestDto, Master> {
    private final OrderService orderService;

    public MasterMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public MasterResponseDto mapToDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setId(master.getId());
        masterResponseDto.setFullName(master.getFullName());
        masterResponseDto.setOrders(master.getOrders());
        return masterResponseDto;
    }

    @Override
    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setFullName(dto.getFullName());
        master.setOrders(orderService.getOrdersById(dto.getOrderIds()));
        return master;
    }
}
