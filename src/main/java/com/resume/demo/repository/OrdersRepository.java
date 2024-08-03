package com.resume.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.demo.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByOrderUserId(String orderUserId);

}
