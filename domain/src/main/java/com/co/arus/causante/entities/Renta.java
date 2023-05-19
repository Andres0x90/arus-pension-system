package com.co.arus.causante.entities;

import com.co.arus.causante.valueobjects.RentaId;
import com.co.arus.causante.valueobjects.Salario;
import com.co.arus.commons.Entity;

import java.util.Date;
import java.util.UUID;

public class Renta extends Entity<RentaId> {
    private Date fechaSolicitud;
    private Salario salario;
    private Integer mesesCotizando;

    public Renta(Date fechaSolicitud, Salario salario, Integer mesesCotizando) {
        super(new RentaId(UUID.randomUUID()));
        this.fechaSolicitud = fechaSolicitud;
        this.salario = salario;
        this.mesesCotizando = mesesCotizando;
    }

    public Date fechaSolicitud() {
        return fechaSolicitud;
    }

    public Salario salario() {
        return salario;
    }

    public Integer mesesCotizando() {
        return mesesCotizando;
    }
}
