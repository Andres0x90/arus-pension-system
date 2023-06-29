package com.co.arus.usecases;

import com.co.arus.causante.Causante;
import com.co.arus.causante.ICausanteDomainService;
import com.co.arus.commands.CausanteCommand;
import com.co.arus.commons.CommandUseCase;
import com.co.arus.commons.EventStorage;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;
import com.co.arus.mapper.IMapper;
import com.co.arus.ports.input.RegistrarCausantePort;
import com.co.arus.ports.output.MessagePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class RegistrarCausanteUseCase extends CommandUseCase<Documento> implements RegistrarCausantePort {

    private ICausanteDomainService causanteDomainService;
    private IMapper IMapper;

    public RegistrarCausanteUseCase(MessagePublisher messagePublisher, EventStorage<Documento> eventStorage, ICausanteDomainService causanteDomainService, IMapper IMapper) {
        super(messagePublisher, eventStorage);
        this.causanteDomainService = causanteDomainService;
        this.IMapper = IMapper;
    }

    @Override
    public Mono<Void> execute(CausanteCommand causanteCommand) {
        Documento documento = new Documento(causanteCommand.getTipoDocumento(), causanteCommand.getDocumento());
        return Mono.just(this.causanteDomainService
                .crearCausante(documento, new Nombre(causanteCommand.getNombres(), causanteCommand.getApellidos()),
                        causanteCommand.getFechaNacimiento(),
                        causanteCommand.getGenero()))
                .map(causanteCreado -> {
                    var causante = this.causanteDomainService.consultarCausante(documento, List.of(causanteCreado));
                    causante.addDomainEvent(causanteCreado);
                    return causante;
                })
                .doOnNext(causante -> this.causanteDomainService
                        .asociarBeneficiario(causante, IMapper.mapToFactory(causanteCommand.getBeneficiario())))
                .doOnNext(causante -> this.causanteDomainService
                        .crearRenta(causante, IMapper.mapToFactory(causanteCommand.getRenta())))
                .map(Causante::getDomainEvents)
                .flux()
                .flatMap(Flux::fromIterable)
                .doOnNext(event -> this.messagePublisher.publish(event).subscribe())
                .then();
    }
}
