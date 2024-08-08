package com.resume.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.demo.repository.OrdersRepository;
import com.resume.demo.model.Orders;
import com.resume.demo.repository.WidgetsRepository;
import com.resume.demo.model.Widgets;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private WidgetsRepository widgetsRepository;

    public List<Orders> findAllOrdersByUser(String userId) {
        return ordersRepository.findByOrderUserid(userId);
    }

    public Orders createUpdateRecord(Orders order) {
        return ordersRepository.save(order);
    }

    public Widgets createUpdateWidgetRecord(Widgets widget) {

        return widgetsRepository.save(widget);
    }

    public void deleteOrder(int orderId) {
        ordersRepository.deleteById(orderId);

    }

    public void deleteWidget(int widgetId) {
        widgetsRepository.deleteById(widgetId);

    }
}
