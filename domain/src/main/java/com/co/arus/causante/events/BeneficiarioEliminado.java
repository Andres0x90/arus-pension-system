package com.co.arus.causante.events;


import com.co.arus.causante.Causante;

public class BeneficiarioEliminado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.creado";

    public BeneficiarioEliminado(Causante causante) {
        super(KEY, causante);
    }
}
