package project.autoservice.service.impl;

import org.springframework.stereotype.Service;
import project.autoservice.dao.ProductRepository;
import project.autoservice.model.Product;
import project.autoservice.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProductById(List<Long> ids) {
        return productRepository.findAllById(ids);
    }
}
