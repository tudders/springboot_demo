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
import com.resume.demo.model.Widgets;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/{userid}")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> orders(@PathVariable("userid") String orderUserid) {
        return ordersService.findAllOrdersByUser(orderUserid);
    }

    @PostMapping("/orders")
    public Orders createUpdateOrder(@PathVariable("userid") String orderUserid, @RequestBody Orders order) {

        return ordersService.createUpdateRecord(order);
    }

    @DeleteMapping("/order/{orderId}")
    public void deleteOrder(@PathVariable("orderId") int orderId) {

        ordersService.deleteOrder(orderId);

    }

    @PostMapping("/orders/widget")
    public Widgets createUpdateWidget(@RequestBody Widgets widget) {

        return ordersService.createUpdateWidgetRecord(widget);

    }

    @DeleteMapping("/order/widget/{widgetId}")
    public void deleteWidget(@PathVariable("widgetId") int widgetId) {

        ordersService.deleteWidget(widgetId);

    }

}
