package com.co.arus.adapters;

import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.ports.output.CausanteRepositoryPort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CausanteEventRepository implements CausanteRepositoryPort {
    @Override
    public Mono<DomainEvent> save(DomainEvent domainEvent) {
        return null;
    }

    @Override
    public Flux<DomainEvent> retrieve(Documento documento) {
        return null;
    }
}
