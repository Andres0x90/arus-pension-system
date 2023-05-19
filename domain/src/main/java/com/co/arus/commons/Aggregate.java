package com.co.arus.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Aggregate <ID>{
    protected ID id;
    protected List<DomainEvent> domainEvents = new ArrayList<>();

    public Aggregate(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void addDomainEvent(DomainEvent domainEvent){
        domainEvents.add(domainEvent);
    }

    public List<DomainEvent> getDomainEvents() {
        return domainEvents;
    }

    protected abstract void applyDomainEvents(DomainEvent domainEvent);

    public Aggregate from(List<DomainEvent> domainEvents){
        domainEvents
                .stream()
                .forEach(this::applyDomainEvents);

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aggregate<?> aggregate = (Aggregate<?>) o;
        return Objects.equals(id, aggregate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
