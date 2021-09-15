package project.autoservice.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.autoservice.dto.request.MasterRequestDto;
import project.autoservice.dto.response.MasterResponseDto;
import project.autoservice.model.Master;
import project.autoservice.model.Order;
import project.autoservice.service.MasterService;
import project.autoservice.service.mapper.MasterMapper;

@RestController
@RequestMapping("/masters")
public class MasterController {
    private MasterService masterService;
    private MasterMapper masterMapper;

    public MasterController(MasterService masterService, MasterMapper masterMapper) {
        this.masterService = masterService;
        this.masterMapper = masterMapper;
    }

    @PostMapping
    public MasterResponseDto create(@RequestBody MasterRequestDto requestDto) {
        Master master = masterMapper.mapToModel(requestDto);
        masterService.create(master);
        return masterMapper.mapToDto(master);
    }

    @PutMapping("/{id}")
    public MasterResponseDto update(@PathVariable Long id,
                                 @RequestBody MasterRequestDto requestDto) {
        Master master = masterMapper.mapToModel(requestDto);
        master.setId(id);
        masterService.update(master);
        return masterMapper.mapToDto(master);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getMasterOrders(@PathVariable Long id) {
        return masterService.getMasterOrdersById(id);
    }

    @GetMapping("/{id}/checkout")
    public BigDecimal getMasterSalary(@PathVariable Long id) {
        return masterService.getMasterSalaryById(id);
    }

}
