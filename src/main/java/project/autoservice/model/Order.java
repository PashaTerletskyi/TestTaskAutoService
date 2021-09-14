package project.autoservice.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
@Table
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Car car;
    @Column(name = "problem_description")
    private String problemDescription;
    @Column(name = "order_date_start")
    private LocalDateTime orderTimeStart;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;
    @OneToMany
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    private Status status;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "order_date_finish")
    private LocalDateTime orderTimeFinish;

    public enum Status {
        ACCEPTED,
        IN_PROCESS,
        SUCCESSFULLY_COMPLETED,
        NOT_SUCCESSFULLY_COMPLETED,
        PAID
    }
}
