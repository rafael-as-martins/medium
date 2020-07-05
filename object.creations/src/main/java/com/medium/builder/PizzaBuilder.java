package com.medium.builder;

import com.medium.builder.core.Pizza;
import com.medium.builder.core.size.Size;

import java.time.LocalDate;

public class PizzaBuilder implements Builder<Pizza> {

    private String name;
    private LocalDate creationDate;
    private Size size;
    private PizzaItemsBuilder pizzaItemsBuilder;

    @Override
    public Pizza build() {

        Pizza pizza = new Pizza();

        pizza.setName(this.name);
        pizza.setCreationDate(this.creationDate);
        pizza.setSize(this.size);
        pizza.setItems(pizzaItemsBuilder.items);

        return pizza;
    }

    public PizzaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PizzaBuilder creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public PizzaBuilder size(Size size) {
        this.size = size;
        return this;
    }

    public PizzaItemsBuilder withItems() {
        this.pizzaItemsBuilder = new PizzaItemsBuilder(this);
        return pizzaItemsBuilder;
    }
}
