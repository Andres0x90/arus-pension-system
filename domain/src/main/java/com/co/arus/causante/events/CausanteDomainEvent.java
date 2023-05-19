package com.co.arus.causante.events;

import com.co.arus.causante.Causante;
import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.causante.factories.IRentaFactory;
import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;

public class CausanteDomainEvent extends DomainEvent {
    private Causante causante;

    public CausanteDomainEvent(String type, Causante causante) {
        super(type);
        this.causante = causante;
    }

    public Causante getCausante() {
        return causante;
    }
}
