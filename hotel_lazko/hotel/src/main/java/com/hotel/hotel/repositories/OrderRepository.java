package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByClientId(Integer id);
}
