package com.hotel.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int num;

    private int floor;

    private int cost_per_night;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private Set<Order> orders;


}