package me.hanwook.order.service;

import me.hanwook.order.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    public void 주문_생성() throws Exception {
        // given
        Long userId = 1L;
        String name = "맛있는 계란";
        int quantity = 3;
        int price = 4000;

        // when
        Order order = orderService.create(userId, name, quantity, price);

        // then
        assertThat(order.getUserId()).isEqualTo(userId);
        assertThat(order.getName()).isEqualTo(name);
        assertThat(order.getQuantity()).isEqualTo(quantity);
        assertThat(order.getPrice()).isEqualTo(price);
    }
}