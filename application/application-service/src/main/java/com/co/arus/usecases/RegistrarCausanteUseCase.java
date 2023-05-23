package com.co.arus.usecases;

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
import reactor.core.publisher.Mono;

public class RegistrarCausanteUseCase extends CommandUseCase<Documento> implements RegistrarCausantePort {

    private ICausanteDomainService causanteDomainService;
    private Mapper mapper;

    public RegistrarCausanteUseCase(MessagePublisher messagePublisher, CausanteRepositoryPort eventStorage) {
        super(messagePublisher, eventStorage);
    }

    @Override
    public Mono<Void> ejecutar(CausanteCommand causanteCommand) {
        return Mono.just(this.causanteDomainService
                .crearCausante(new Documento(causanteCommand.getTipoDocumento(), causanteCommand.getDocumento()),
                        new Nombre(causanteCommand.getNombres(), causanteCommand.getApellidos()),
                        causanteCommand.getFechaNacimiento(),
                        causanteCommand.getGenero(),
                        mapper.mapToFactory(causanteCommand.getBeneficiario()),
                        mapper.mapToFactory(causanteCommand.getRenta())))
                .doOnNext(causanteCreado -> this.messagePublisher.publish(causanteCreado).subscribe())
                .then();
    }
}
