package project.autoservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

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
    @OneToMany()
    @JoinTable(name = "orders_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;
    @ManyToMany
    private List<Product> products;
    @Enumerated
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
