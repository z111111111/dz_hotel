package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).get();
    }

    public List<Order> getOrdersByClientId(Integer id){
        return orderRepository.findByClientId(id);
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public void delete(Integer id){
        orderRepository.deleteById(id);
    }
}
