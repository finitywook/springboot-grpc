package me.hanwook.order.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Long userId;

    @Column(length = 200)
    private String name;

    private int quantity;

    private int price;

    @Builder
    public Order(Long userId, String name, int quantity, int price) {
        this.userId = userId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
