package com.co.arus.causante.factories;

import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.valueobjects.RentaId;
import com.co.arus.causante.valueobjects.Salario;

import java.util.Date;

public class RentaFactory implements IRentaFactory {

    private RentaId id;
    private Date fechaSolicitud;
    private Salario salario;
    private Integer mesesCotizando;


    @Override
    public Renta construir() {
        return new Renta(fechaSolicitud, salario, mesesCotizando);
    }

    public RentaFactory id(RentaId val) {
        id = val;
        return this;
    }

    public RentaFactory fechaSolicitud(Date val) {
        fechaSolicitud = val;
        return this;
    }

    public RentaFactory salario(Salario val) {
        salario = val;
        return this;
    }

    public RentaFactory mesesCotizando(Integer val) {
        mesesCotizando = val;
        return this;
    }
}
