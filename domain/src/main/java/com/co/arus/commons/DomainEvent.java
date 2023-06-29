package com.co.arus.commons;

import java.util.UUID;

public abstract class DomainEvent {
    protected final String id;
    protected final String type;

    public DomainEvent(String type) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
