package com.co.arus.causante.events;


import com.co.arus.causante.Causante;

public class RentaCreada extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.renta.creada";

    public RentaCreada(Causante causante) {
        super(KEY, causante);
    }
}
