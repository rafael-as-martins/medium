package com.medium.client.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContext {
    public static final String CORRELATION_IDENTIFIER = "correlation-id";
    private String correlationId;
}
