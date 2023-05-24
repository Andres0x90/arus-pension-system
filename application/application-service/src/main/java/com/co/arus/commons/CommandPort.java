package com.co.arus.commons;

import reactor.core.publisher.Mono;

public interface CommandPort<AggregateCommand> {
    Mono<Void> execute(AggregateCommand aggregateCommand);
}
