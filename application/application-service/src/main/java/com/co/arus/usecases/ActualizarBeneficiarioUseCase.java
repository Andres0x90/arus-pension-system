package com.co.arus.usecases;

import com.co.arus.causante.Causante;
import com.co.arus.causante.ICausanteDomainService;
import com.co.arus.commands.CausanteCommand;
import com.co.arus.commons.CommandUseCase;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.mapper.IMapper;
import com.co.arus.ports.input.ActualizarBeneficiarioPort;
import com.co.arus.ports.output.CausanteRepositoryPort;
import com.co.arus.ports.output.MessagePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class ActualizarBeneficiarioUseCase extends CommandUseCase<Documento> implements ActualizarBeneficiarioPort {

    private ICausanteDomainService domainService;
    private IMapper IMapper;

    public ActualizarBeneficiarioUseCase(MessagePublisher messagePublisher, CausanteRepositoryPort eventStorage, ICausanteDomainService domainService, IMapper IMapper) {
        super(messagePublisher, eventStorage);
        this.domainService = domainService;
        this.IMapper = IMapper;
    }

    @Override
    public Mono<Void> execute(CausanteCommand causanteCommand) {
        Documento documento = new Documento(causanteCommand.getTipoDocumento(), causanteCommand.getDocumento());
        return eventStorage.retrieve(documento)
                .collect(Collectors.toList())
                .map(domainEvents -> domainService.consultarCausante(documento, domainEvents))
                .doOnNext(causante -> domainService
                        .actualizarBeneficiario(causante, IMapper.mapToFactory(causanteCommand.getBeneficiario())))
                .map(Causante::getDomainEvents)
                .flux()
                .flatMap(Flux::fromIterable)
                .doOnNext(domainEvent -> this.messagePublisher.publish(domainEvent).subscribe())
                .then();
    }
}
