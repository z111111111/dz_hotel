package com.hotel.hotel.models;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

    public void updateClient(Client client){
        if(client.firstName != null){
            this.firstName = client.firstName;
        }
        if(client.lastName != null){
            this.lastName = client.lastName;
        }
        if(client.middleName != null){
            this.middleName = client.middleName;
        }
    }
}
