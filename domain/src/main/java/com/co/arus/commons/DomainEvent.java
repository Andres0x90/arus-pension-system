package com.co.arus.commons;

import java.util.Date;
import java.util.UUID;

public abstract class DomainEvent {
    protected final String id;
    protected final String type;
    protected final Date date;

    public DomainEvent(String type) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.date = new Date();
    }

    public DomainEvent(String id, String type, Date date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
}
