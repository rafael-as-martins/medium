package com.medium.factory;

import com.medium.factory.core.Pizza;

public class OrderFactory {

    public static Order getOrder(String order) {

        if(order != null){
            if(order.equals("Pizza")){
                return new Pizza();
            }
        }

        return null;
    }
}
