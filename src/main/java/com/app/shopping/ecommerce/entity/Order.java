package com.app.shopping.ecommerce.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderBy;
    private String Location;
    private int items;
    private double price;
    private Date placedOn;
    private Date deliveryOn;
    private String status;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
