package com.medium.builder;

import com.medium.builder.core.Item;

public class ItemBuilder{

    private String name;
    private Integer quantity;
    private PizzaItemsBuilder pizzaItemsBuilder;

    public ItemBuilder(PizzaItemsBuilder pizzaItemsBuilder) {
        this.pizzaItemsBuilder = pizzaItemsBuilder;
    }

    public ItemBuilder() {

    }

    public Item build() {
        Item item = new Item();
        item.setName(this.name);
        item.setQuantity(this.quantity);
        return item;
    }

    public ItemBuilder name(String name) {
        this.name = name;
        return this;
    }
    public ItemBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PizzaItemsBuilder add() {
        Item item = build();
        this.pizzaItemsBuilder.addItem(item);
        return this.pizzaItemsBuilder;
    }
}
