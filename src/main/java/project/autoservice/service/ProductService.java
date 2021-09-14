package project.autoservice.service;

import project.autoservice.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    Product update(Product product);

    Product getById(Long id);

    List<Product> getProductById(List<Long> ids);
}
