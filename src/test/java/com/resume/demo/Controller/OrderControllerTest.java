package com.resume.demo.Controller;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.resume.demo.controller.OrdersController;
import com.resume.demo.model.Orders;
import com.resume.demo.service.OrdersService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    private OrdersController ordersController;

    @Mock
    private OrdersService ordersService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();
    }

    @Test
    public void testFindAllOrdersByUser() throws Exception {

        Orders order1 = new Orders(3, "ABCD", "123", "TEXT", LocalDateTime.now());
        List<Orders> orders = new ArrayList<Orders>();
        orders.add(order1);

        when(ordersService.findAllOrdersByUser("123")).thenReturn(orders);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/123/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$[0].orderId", is(3)));
    }

}
