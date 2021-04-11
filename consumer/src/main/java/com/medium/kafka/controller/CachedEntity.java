package com.medium.kafka.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CachedEntity {
    private int entityId;

    public CachedEntity(@JsonProperty("entityId") int entityId){
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return String.format("Cached Entity with id %d", entityId);
    }
}
