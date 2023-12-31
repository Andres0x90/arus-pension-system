package com.co.arus.usecases;

import com.co.arus.causante.Causante;
import com.co.arus.causante.ICausanteDomainService;
import com.co.arus.commands.CausanteCommand;
import com.co.arus.commons.CommandUseCase;
import com.co.arus.commons.EventStorage;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;
import com.co.arus.ports.input.ActualizarCausantePort;
import com.co.arus.ports.output.CausanteRepositoryPort;
import com.co.arus.ports.output.MessagePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class ActualizarCausanteUseCase extends CommandUseCase<Documento> implements ActualizarCausantePort {
    private ICausanteDomainService domainService;

    public ActualizarCausanteUseCase(MessagePublisher messagePublisher, CausanteRepositoryPort eventStorage, ICausanteDomainService causanteDomainService) {
        super(messagePublisher, eventStorage);
        this.domainService = causanteDomainService;
    }

    @Override
    public Mono<Void> execute(CausanteCommand causanteCommand) {
        Documento documento = new Documento(causanteCommand.getTipoDocumento(), causanteCommand.getDocumento());
        return this.retrieveEvents(documento)
                .collect(Collectors.toList())
                .map(domainEvents -> domainService.consultarCausante(documento, domainEvents))
                .doOnNext(causante -> domainService.actualizarCausante(causante, new Nombre(causanteCommand.getNombres(), causanteCommand.getApellidos()),
                         causanteCommand.getFechaNacimiento(), causanteCommand.getGenero()))
                .map(Causante::getDomainEvents)
                .flux()
                .flatMap(Flux::fromIterable)
                .doOnNext(domainEvent -> this.publishEvents(domainEvent).subscribe())
                .then();
    }
}
