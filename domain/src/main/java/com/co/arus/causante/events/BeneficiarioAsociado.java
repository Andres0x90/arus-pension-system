package com.co.arus.causante.events;


import com.co.arus.causante.Causante;


public class BeneficiarioAsociado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.beneficiario.asociado";

    public BeneficiarioAsociado(Causante causante) {
        super(KEY, causante);
    }
}
