package com.co.arus.commons;

import java.util.Objects;

public abstract class BaseId<T> {
    protected final T id;

    public BaseId(T id) {
        this.id = id;
    }

    public T getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
