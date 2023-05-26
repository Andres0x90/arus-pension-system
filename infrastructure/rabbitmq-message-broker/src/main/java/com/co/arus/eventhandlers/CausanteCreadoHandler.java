package com.co.arus.eventhandlers;

import com.co.arus.causante.events.CausanteCreado;
import com.co.arus.causante.events.RentaCreada;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.handlers.EventHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CausanteCreadoHandler implements EventHandler<CausanteCreado> {

    @Override
    public Mono<Void> handle(DomainEvent<CausanteCreado> message) {
        return Mono.just("Causante creado escuchado").doOnNext(System.out::println).then();
    }
}
