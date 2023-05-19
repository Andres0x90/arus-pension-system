package com.co.arus.causante.events;


import com.co.arus.causante.Causante;

public class CausanteCreado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.creado";

    public CausanteCreado(Causante causante) {
        super(KEY, causante);
    }
}
