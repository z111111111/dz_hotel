package com.hoteljavafx;

import javafx.beans.property.*;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private IntegerProperty id;
    private StringProperty name;
    private Set<AdditionalService> additionalServices;

    public Order(long id, String name, Set additionalServices) {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.additionalServices = new SimpleSetProperty<>();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Set<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public void addAdditionalService(AdditionalService additionalService) {
        additionalServices.add(additionalService);
    }

    public void removeAdditionalService(AdditionalService additionalService) {
        additionalServices.remove(additionalService);
    }
}