package com.hotel.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="add_services")
public class AdditionalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Long cost_value;

    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    private Order order;

}