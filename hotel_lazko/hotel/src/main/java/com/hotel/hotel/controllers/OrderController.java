package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.services.ClientService;
import com.hotel.hotel.services.OrderService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        try{
            Order order = orderService.getOrderById(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
}
