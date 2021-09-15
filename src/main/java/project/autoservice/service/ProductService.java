package project.autoservice.service;

import java.util.List;
import project.autoservice.model.Product;

public interface ProductService {
    Product create(Product product);

    Product update(Product product);

    Product getById(Long id);

    List<Product> getProductById(List<Long> ids);
}
