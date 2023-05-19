package com.co.arus.commons;

public abstract class DomainEvent {
    protected final String type;

    public DomainEvent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
