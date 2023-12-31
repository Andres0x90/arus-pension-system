package com.co.arus.ports.input;

import com.co.arus.commands.CausanteCommand;
import com.co.arus.commons.CommandPort;
import reactor.core.publisher.Mono;

public interface RegistrarCausantePort extends CommandPort<CausanteCommand> {
}
