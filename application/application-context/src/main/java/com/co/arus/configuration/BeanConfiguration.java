package com.co.arus.configuration;

import com.co.arus.causante.CausanteDomainService;
import com.co.arus.mapper.IMapper;
import com.co.arus.ports.input.RegistrarCausantePort;
import com.co.arus.ports.output.CausanteRepositoryPort;
import com.co.arus.ports.output.MessagePublisher;
import com.co.arus.usecases.RegistrarCausanteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    RegistrarCausantePort registrarCausantePort(MessagePublisher messagePublisher, CausanteRepositoryPort eventStorage, IMapper IMapper){
        return new RegistrarCausanteUseCase(messagePublisher, eventStorage, new CausanteDomainService(), IMapper);
    }
}
