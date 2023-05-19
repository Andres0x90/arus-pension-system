package com.co.arus.causante.events;


import com.co.arus.causante.Causante;

public class CausanteEliminado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.eliminado";

    public CausanteEliminado(Causante causante) {
        super(KEY, causante);
    }
}
