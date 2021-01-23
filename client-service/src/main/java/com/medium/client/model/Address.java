package com.medium.client.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

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
