package com.co.arus.causante.events;

import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;

public class CausanteDomainEvent extends DomainEvent {
    private  Documento documento;
    private  Nombre nombre;
    private  Date fechaNacimiento;
    private  Genero genero;
    private  Beneficiario beneficiario;
    private  Renta renta;

    public CausanteDomainEvent(String type) {
        super(type);
    }

    public CausanteDomainEvent(String type, Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero, Beneficiario beneficiario, Renta renta) {
        super(type);
        this.documento = documento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.beneficiario = beneficiario;
        this.renta = renta;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public Renta getRenta() {
        return renta;
    }
}
