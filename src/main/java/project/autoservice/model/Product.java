package project.autoservice.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
}
