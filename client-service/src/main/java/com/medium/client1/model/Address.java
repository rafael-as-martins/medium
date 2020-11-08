package com.medium.client1.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Address {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
}
