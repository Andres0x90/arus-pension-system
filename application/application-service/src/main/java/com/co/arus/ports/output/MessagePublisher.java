package com.co.arus.ports.output;

import com.co.arus.commons.DomainEvent;
import reactor.core.publisher.Mono;

public interface MessagePublisher {
    Mono<Void> publish(DomainEvent domainEvent);
}
