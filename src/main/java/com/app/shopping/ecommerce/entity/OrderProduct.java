package com.app.shopping.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders_products")
public class OrderProduct {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
        private int quantity;
        private double price;
        // Other fields related to the association (e.g., quantity)
    }
