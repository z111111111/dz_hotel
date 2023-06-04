package com.hoteljavafx;

import javafx.beans.property.*;

public class AdditionalService {
    private IntegerProperty id;
    private StringProperty name;
    private LongProperty costValue;

    public AdditionalService() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.costValue = new SimpleLongProperty();
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

    public long getCostValue() {
        return costValue.get();
    }

    public LongProperty costValueProperty() {
        return costValue;
    }

    public void setCostValue(long costValue) {
        this.costValue.set(costValue);
    }
}