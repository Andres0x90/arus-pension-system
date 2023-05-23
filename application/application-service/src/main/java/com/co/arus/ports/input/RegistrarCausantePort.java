package com.co.arus.ports.input;

import com.co.arus.commands.CausanteCommand;
import reactor.core.publisher.Mono;

public interface RegistrarCausantePort {
    Mono<Void> ejecutar(CausanteCommand causanteCommand);
}
