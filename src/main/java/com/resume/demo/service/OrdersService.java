package com.resume.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.demo.repository.OrdersRepository;
import com.resume.demo.model.Orders;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAllOrdersByUser(String userId) {
        return ordersRepository.findByOrderUserId(userId);
    }

    public void createUpdateRecord(Orders order) {
        System.out.println(order.toString());
        Object response = ordersRepository.save(order);
        System.out.println(response.toString());

    }

    public void deleteOrder(int orderId) {
        ordersRepository.deleteById(orderId);

    }
}
