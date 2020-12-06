package com.medium.client1.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
}
