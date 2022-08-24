package me.hanwook.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hanwook.order.entity.Order;
import me.hanwook.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order create(Long userId, String name, int quantity, int price) {
        return orderRepository.save(
                Order.builder()
                        .userId(userId)
                        .name(name)
                        .quantity(quantity)
                        .price(price)
                        .build()
        );
    }
}
