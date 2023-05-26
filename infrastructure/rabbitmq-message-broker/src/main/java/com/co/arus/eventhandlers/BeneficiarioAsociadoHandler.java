package com.co.arus.eventhandlers;

import com.co.arus.causante.events.BeneficiarioAsociado;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.handlers.EventHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BeneficiarioAsociadoHandler implements EventHandler<BeneficiarioAsociado> {
    @Override
    public Mono<Void> handle(DomainEvent<BeneficiarioAsociado> message) {
         return Mono.just("Beneficiario Asociado escuchado").doOnNext(System.out::println).then();
    }
}
