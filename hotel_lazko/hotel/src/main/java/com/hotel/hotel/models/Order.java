package com.hotel.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    @JsonIgnore
    private Room room;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<AdditionalService> add_services;

    private Date date_in;

    private Date date_out;

    private double totalCost;

    @PostLoad
    @PostUpdate
    private void calculateTotalCost() {

        long totalNights = date_in.toInstant().until(date_out.toInstant(), ChronoUnit.DAYS);
        double roomCost = room.getCost_per_night() * totalNights;


        Long additionalServicesCost = null;
        for (AdditionalService additionalService : add_services) {
            additionalServicesCost = additionalService.getCost_value();
        }

        totalCost = roomCost + additionalServicesCost* totalNights;
    }
    
}
