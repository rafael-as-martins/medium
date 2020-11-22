package com.medium.client1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Address {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
}
