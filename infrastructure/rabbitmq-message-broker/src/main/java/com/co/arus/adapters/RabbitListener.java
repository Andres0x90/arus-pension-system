package com.co.arus.adapters;

import com.co.arus.causante.events.BeneficiarioAsociado;
import com.co.arus.causante.events.CausanteActualizado;
import com.co.arus.causante.events.CausanteCreado;
import com.co.arus.causante.events.RentaCreada;
import com.co.arus.eventhandlers.BeneficiarioAsociadoHandler;
import com.co.arus.eventhandlers.CausanteActualizadoHandler;
import com.co.arus.eventhandlers.CausanteCreadoHandler;
import com.co.arus.eventhandlers.RentaCreadaHandler;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitListener {
    @Autowired
    private  CausanteCreadoHandler causanteCreadoHandler;
    @Autowired
    private BeneficiarioAsociadoHandler beneficiarioAsociadoHandler;
    @Autowired
    private RentaCreadaHandler rentaCreadaHandler;
    @Autowired
    private CausanteActualizadoHandler causanteActualizadoHandler;

    @Bean
    public HandlerRegistry handlerRegistry(){
        return HandlerRegistry.register()
                .listenEvent(CausanteCreado.KEY, causanteCreadoHandler, CausanteCreado.class)
                .listenEvent(BeneficiarioAsociado.KEY, beneficiarioAsociadoHandler, BeneficiarioAsociado.class)
                .listenEvent(RentaCreada.KEY, rentaCreadaHandler, RentaCreada.class)
                .listenEvent(CausanteActualizado.KEY, causanteActualizadoHandler, CausanteActualizado.class);

    }
}
