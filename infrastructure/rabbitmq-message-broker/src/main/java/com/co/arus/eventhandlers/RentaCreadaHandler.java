package com.co.arus.eventhandlers;

import com.co.arus.causante.events.RentaCreada;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.handlers.EventHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RentaCreadaHandler implements EventHandler<RentaCreada> {
    @Override
    public Mono<Void> handle(DomainEvent<RentaCreada> message) {
       return Mono.just("Renta creada escuchado").doOnNext(System.out::println).then();
    }
}
