package com.co.arus.causante.events;


import com.co.arus.causante.Causante;

public class CausanteActualizado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.actualizado";

    public CausanteActualizado(Causante causante) {
        super(KEY, causante);
    }
}
