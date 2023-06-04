package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    List<Client> findByFirstName(String firstName);
}
