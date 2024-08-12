
package com.resume.demo.Service;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import com.resume.demo.service.OrdersService;
import com.resume.demo.model.Orders;
import com.resume.demo.repository.OrdersRepository;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTests {

    @Autowired
    private OrdersRepository ordersRepository;

    @BeforeEach
    public void setUp() {
        // setup code
        Orders order1 = new Orders(1, "ABCD", "123", "TEXT", LocalDateTime.now());
        Orders order2 = new Orders(2, "XYZ", "123", "TEXT", LocalDateTime.now());
        Orders order3 = new Orders(3, "ABCD", "123", "TEXT", LocalDateTime.now());

        ordersRepository.save(order1);
        ordersRepository.save(order2);
        ordersRepository.save(order3);

    }

    @Test
    public void testFindAllOrdersByUser() {
        // test code
        OrdersService ordersService = new OrdersService(ordersRepository);
        // no orders for user 123
        assertTrue(ordersService.findAllOrdersByUser("123").size() == 0);
        // 2 orders for user ABCD
        assertTrue(ordersService.findAllOrdersByUser("ABCD").size() == 2);

    }

    /*
     * @Test
     * public void testCreateUpdateRecord() {
     * // test code
     * }
     * 
     * @Test
     * public void testCreateUpdateWidgetRecord() {
     * // test code
     * }
     * 
     * @Test
     * public void testDeleteOrder() {
     * // test code
     * }
     * 
     * @Test
     * public void testDeleteWidget() {
     * // test code
     * }
     */

}
