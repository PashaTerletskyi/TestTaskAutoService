package project.autoservice.controller;

import org.springframework.web.bind.annotation.*;
import project.autoservice.dto.request.ProductRequestDto;
import project.autoservice.dto.response.ProductResponseDto;
import project.autoservice.model.Product;
import project.autoservice.service.ProductService;
import project.autoservice.service.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductRequestDto requestDto) {
        Product product = productMapper.mapToModel(requestDto);
        productService.create(product);
        return productMapper.mapToDto(product);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = productMapper.mapToModel(requestDto);
        product.setId(id);
        productService.update(product);
        return productMapper.mapToDto(product);
    }
}
