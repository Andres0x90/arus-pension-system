package com.co.arus;

import com.co.arus.commands.CausanteCommand;
import com.co.arus.commands.Response;
import com.co.arus.commons.exceptions.DomainException;
import com.co.arus.ports.input.ActualizarCausantePort;
import com.co.arus.ports.input.RegistrarCausantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@Configuration
public class CausanteRouter {
    private final String PATH = "/api/causante";

    @Autowired
    private RegistrarCausantePort registrarCausantePort;
    @Autowired
    private ActualizarCausantePort actualizarCausantePort;

    @Bean
    public RouterFunction<ServerResponse> registrarCausante(){
        return RouterFunctions.route(RequestPredicates.POST(PATH.concat("/registrar")),
                request -> request.bodyToMono(CausanteCommand.class)
                        .flatMap(causanteCommand -> registrarCausantePort.execute(causanteCommand)
                                .then(ServerResponse
                                        .created(URI.create(PATH.concat("/").concat(causanteCommand.getDocumento())))
                                        .bodyValue(Response.builder().message("Causante Registrado").build())))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(Response.builder().message(throwable.getMessage()).build())));
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarCausante(){
        return RouterFunctions.route(RequestPredicates.PUT(PATH.concat("/actualizar")),
                request -> request.bodyToMono(CausanteCommand.class)
                        .flatMap(causanteCommand -> actualizarCausantePort.execute(causanteCommand)
                                .then(ServerResponse
                                        .ok()
                                        .bodyValue(Response.builder().message("Causante Actualizado").build())))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(Response.builder().message(throwable.getMessage()).build())));
    }
}
