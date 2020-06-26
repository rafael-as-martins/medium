package com.medium.builder;

import com.medium.core.Item;

import java.util.HashSet;
import java.util.Set;

public final class PizzaItemsBuilder {

    public Set<Item> items;
    private PizzaBuilder pizzaBuilder;

    public PizzaItemsBuilder(PizzaBuilder pizzaBuilder){
        this.pizzaBuilder = pizzaBuilder;
        this.items = new HashSet<>();
    }

    public ItemBuilder addItem() {
        return Item.Builder(this);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public PizzaBuilder buildItems() {
        return this.pizzaBuilder;
    }
}
