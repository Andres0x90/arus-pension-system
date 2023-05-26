package com.co.arus.adapters;

import com.co.arus.commons.DomainEvent;
import com.co.arus.ports.output.MessagePublisher;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class RabbitPublisher implements MessagePublisher {

    @Autowired
    private DomainEventBus domainEventBus;

    @Override
    public Mono<Void> publish(DomainEvent domainEvent) {
        System.out.println("Published".concat(domainEvent.getType()));
        return Mono.from(domainEventBus.
                emit(new org.reactivecommons.api.domain.DomainEvent<>(domainEvent.getType(), UUID.randomUUID().toString(), domainEvent)));
    }
}
