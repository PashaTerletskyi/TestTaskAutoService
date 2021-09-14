package project.autoservice.controller;

import org.springframework.web.bind.annotation.*;
import project.autoservice.dto.request.OwnerRequestDto;
import project.autoservice.dto.response.OwnerResponseDto;
import project.autoservice.model.Order;
import project.autoservice.model.Owner;
import project.autoservice.service.OwnerService;
import project.autoservice.service.mapper.OwnerMapper;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;

    public OwnerController(OwnerService ownerService, OwnerMapper ownerMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerMapper.mapToModel(requestDto);
        ownerService.create(owner);
        return ownerMapper.mapToDto(owner);
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id,
                                   @RequestBody OwnerRequestDto requestDto) {
        Owner owner = ownerMapper.mapToModel(requestDto);
        owner.setId(id);
        ownerService.update(owner);
        return ownerMapper.mapToDto(owner);
    }

    @GetMapping("/{id}")
    public List<Order> getOrdersById(@PathVariable Long id) {
        return ownerService.get(id).getOrders();
    }
}
