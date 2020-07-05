package com.medium.factory;

import com.medium.factory.core.Pizza;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OrderSupplierFactory {

    final static Map<String, Supplier<? extends Order>> orders;

    static{
        orders = new HashMap<>();
        orders.put("pizza", Pizza::new);
    }


    /**
     *
     *
     * Simplified way using jdk 1.8, compared to the other factory class,
     * in 2 lines we can invoke the correspondent order constructor, otherwise
     * N if-else statements would appear.
     *
     * Note: This solution is not scalable whenever the Orders constructor start receiving
     * multiple arguments, in this case, builder it's the suggested pattern to use.
     *
     *@param order to request
     * @return an Order
     */
    public static Order getOrder(String order) {

        if(order != null){
            Supplier<? extends Order> supplier = orders.get(order.toLowerCase());
            return supplier.get();
        }

        return null;
    }
}
