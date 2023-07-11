package com.co.arus.adapters;

import com.co.arus.causante.events.CausanteDomainEvent;
import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.crud.CausanteEventCrudRepository;
import com.co.arus.data.CausanteEventData;
import com.co.arus.mapper.Mapper;
import com.co.arus.ports.output.CausanteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CausanteEventRepository implements CausanteRepositoryPort {

    @Autowired
    private CausanteEventCrudRepository causanteEventCrudRepository;

    @Override
    public Mono<DomainEvent> save(DomainEvent domainEvent) {
        return Mono.just((CausanteDomainEvent)domainEvent)
                .map(Mapper::toData)
                .map(causanteEventCrudRepository::save)
                .map(Mapper::toEntity);
    }

    @Override
    public Flux<DomainEvent> retrieve(Documento documento) {
        return Flux.fromIterable(causanteEventCrudRepository.findByDocumento(documento.getId()))
                .map(Mapper::toEntity);
    }
}
