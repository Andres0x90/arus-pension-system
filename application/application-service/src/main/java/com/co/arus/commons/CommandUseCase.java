package com.co.arus.commons;

import com.co.arus.ports.output.MessagePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CommandUseCase<ID> {
    protected MessagePublisher messagePublisher;
    protected EventStorage<ID> eventStorage;

    protected CommandUseCase(MessagePublisher messagePublisher, EventStorage<ID> eventStorage) {
        this.messagePublisher = messagePublisher;
        this.eventStorage = eventStorage;
    }

    protected Flux<DomainEvent> retrieveEvents(ID id){
        return this.eventStorage.retrieve(id);
    }

    protected Mono<Void> publishEvents(DomainEvent domainEvent){
        return this.messagePublisher.publish(domainEvent);
    }
}
