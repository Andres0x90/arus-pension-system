package com.co.arus.usecases;

import com.co.arus.causante.Causante;
import com.co.arus.causante.ICausanteDomainService;
import com.co.arus.causante.factories.BeneficiarioFactory;
import com.co.arus.commands.CausanteCommand;
import com.co.arus.commons.CommandUseCase;
import com.co.arus.commons.EventStorage;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;
import com.co.arus.mapper.Mapper;
import com.co.arus.ports.input.RegistrarCausantePort;
import com.co.arus.ports.output.CausanteRepositoryPort;
import com.co.arus.ports.output.MessagePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RegistrarCausanteUseCase extends CommandUseCase<Documento> implements RegistrarCausantePort {

    private ICausanteDomainService causanteDomainService;
    private Mapper mapper;

    public RegistrarCausanteUseCase(MessagePublisher messagePublisher, CausanteRepositoryPort eventStorage) {
        super(messagePublisher, eventStorage);
    }

    @Override
    public Mono<Void> execute(CausanteCommand causanteCommand) {
        return Mono.just(this.causanteDomainService
                .crearCausante(new Documento(causanteCommand.getTipoDocumento(), causanteCommand.getDocumento()),
                        new Nombre(causanteCommand.getNombres(), causanteCommand.getApellidos()),
                        causanteCommand.getFechaNacimiento(),
                        causanteCommand.getGenero()).getCausante())
                .map(causante -> this.causanteDomainService
                        .asociarBeneficiario(causante, mapper.mapToFactory(causanteCommand.getBeneficiario()))
                        .getCausante())
                .map(causante -> this.causanteDomainService
                        .crearRenta(causante, mapper.mapToFactory(causanteCommand.getRenta()))
                        .getCausante())
                .map(Causante::getDomainEvents)
                .flux()
                .flatMap(Flux::fromIterable)
                .doOnNext(event -> this.messagePublisher.publish(event).subscribe())
                .then();
    }
}
