package project.autoservice.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.autoservice.dto.request.OrderRequestDto;
import project.autoservice.dto.response.OrderResponseDto;
import project.autoservice.model.Order;
import project.autoservice.model.Product;
import project.autoservice.service.OrderService;
import project.autoservice.service.ProductService;
import project.autoservice.service.mapper.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ProductService productService;

    public OrderController(OrderService orderService,
                           OrderMapper orderMapper,
                           ProductService productService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.productService = productService;
    }

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto requestDto) {
        Order order = orderMapper.mapToModel(requestDto);
        orderService.create(order);
        return orderMapper.mapToDto(order);
    }

    @PostMapping("/products")
    public OrderResponseDto addProduct(@RequestParam Long orderId,
                                       @RequestParam Long productId) {
        Order order = orderService.getById(orderId);
        List<Product> addProduct = order.getProducts();
        Product product = productService.getById(productId);
        addProduct.add(product);
        order.setProducts(addProduct);
        orderService.update(order);
        return orderMapper.mapToDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto requestDto) {
        Order order = orderMapper.mapToModel(requestDto);
        order.setId(id);
        orderService.update(order);
        return orderMapper.mapToDto(order);
    }

    @PutMapping("/{id}/status")
    public OrderResponseDto updateStatus(@PathVariable Long id,
                                   @RequestParam Order.Status status) {
        Order order = orderService.getById(id);
        order.setStatus(status);
        orderService.update(order);
        return orderMapper.mapToDto(order);
    }

    @GetMapping("/final_price/{id}")
    public BigDecimal getCostCalculation(@PathVariable Long id) {
        return orderService.getCostById(id);
    }
}
