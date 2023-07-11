package com.co.arus.eventhandlers;

import com.co.arus.causante.events.CausanteActualizado;
import com.co.arus.causante.events.CausanteCreado;
import com.co.arus.ports.output.CausanteRepositoryPort;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CausanteActualizadoHandler implements EventHandler<CausanteActualizado> {

    @Autowired
    private CausanteRepositoryPort causanteRepositoryPort;

    @Override
    public Mono<Void> handle(DomainEvent<CausanteActualizado> message) {
        return causanteRepositoryPort.save(message.getData())
                .then();
    }
}