package com.co.arus;

import com.co.arus.commands.CausanteCommand;
import com.co.arus.commands.Response;
import com.co.arus.ports.input.RegistrarCausantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
public class CausanteRouter {
    private final String PATH = "/api/causante";

    @Autowired
    private RegistrarCausantePort registrarCausantePort;

    @Bean
    public RouterFunction<ServerResponse> registrarCausante(){
        return RouterFunctions.route(RequestPredicates.POST(PATH.concat("/registrar")),
                request -> request.bodyToMono(CausanteCommand.class)
                        .flatMap(causanteCommand -> registrarCausantePort.execute(causanteCommand)
                                .then(ServerResponse
                                        .created(URI.create(PATH.concat("/").concat(causanteCommand.getDocumento())))
                                        .bodyValue(Response.builder().message("Causante Registrado").build()))));
    }
}
