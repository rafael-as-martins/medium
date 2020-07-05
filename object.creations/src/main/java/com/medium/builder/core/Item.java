package com.medium.builder.core;

import com.medium.builder.ItemBuilder;
import com.medium.builder.PizzaItemsBuilder;

public class Item {

    private String name;

    private int quantity;

    public Item() {
    }

    public static ItemBuilder Builder(PizzaItemsBuilder pizzaItemsBuilder) {
        return new ItemBuilder(pizzaItemsBuilder);
    }

    public static ItemBuilder Builder() {
        return new ItemBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
