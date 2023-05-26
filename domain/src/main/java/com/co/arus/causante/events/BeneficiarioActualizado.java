package com.co.arus.causante.events;


import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;


public class BeneficiarioActualizado extends CausanteDomainEvent {

    public static final String KEY = "com.co.arus.causante.beneficiario.actualizado";

    public BeneficiarioActualizado(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero, Beneficiario beneficiario, Renta renta) {
        super(KEY, documento, nombre, fechaNacimiento, genero, beneficiario, renta);
    }
}
