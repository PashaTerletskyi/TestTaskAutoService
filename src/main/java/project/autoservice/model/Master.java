package project.autoservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "masters")
@Table
@Data
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @OneToMany
    private List<Order> orders;
}
