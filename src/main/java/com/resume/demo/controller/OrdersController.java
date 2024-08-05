package com.resume.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.resume.demo.service.OrdersService;
import com.resume.demo.model.Orders;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/{userid}")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> orders(@PathVariable("userid") String userId) {
        return ordersService.findAllOrdersByUser(userId);
    }

    @PostMapping("/orders")
    public Orders orders(@PathVariable("userid") String userId, @RequestBody Orders order) {

        return ordersService.createUpdateRecord(order);
    }

    @DeleteMapping("/order/{orderId}")
    public void orders(@PathVariable("orderId") int orderId) {

        ordersService.deleteOrder(orderId);
    }

}
