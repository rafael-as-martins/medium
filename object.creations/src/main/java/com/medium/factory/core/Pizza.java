package com.medium.factory.core;

import com.medium.factory.Order;

public class Pizza implements Order {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String eat() {
        return "Eating Pizza...";
    }
}
