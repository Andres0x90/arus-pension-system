package com.co.arus.causante.events;


import com.co.arus.causante.Causante;


public class BeneficiarioActualizado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.beneficiario.actualizado";

    public BeneficiarioActualizado(Causante causante) {
        super(KEY, causante);
    }
}
