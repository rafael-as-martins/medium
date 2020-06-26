package com.medium.core;

import com.medium.builder.Builder;
import com.medium.builder.PizzaBuilder;
import com.medium.core.size.Size;

import java.time.LocalDate;
import java.util.Set;

public class Pizza {

    private String name;

    private Size size;

    private LocalDate creation_date;

    private Set<Item> items;

    public Pizza() {
    }

    public static PizzaBuilder Builder() {
        return new PizzaBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreationDate(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
