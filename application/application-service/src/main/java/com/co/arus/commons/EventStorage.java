package com.co.arus.commons;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventStorage<ID> {
    Mono<DomainEvent> save(DomainEvent domainEvent);
    Flux<DomainEvent> retrieve(ID id);
}
