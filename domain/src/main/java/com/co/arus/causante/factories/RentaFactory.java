package com.co.arus.causante.factories;

import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.valueobjects.RentaId;
import com.co.arus.causante.valueobjects.Salario;

import java.util.Date;

public class RentaFactory implements IRentaFactory {

    private Date fechaSolicitud;
    private Salario salario;
    private Integer mesesCotizando;

    public static RentaFactory builder(){
        return new RentaFactory();
    }

    @Override
    public Renta construir() {
        return new Renta(fechaSolicitud, salario, mesesCotizando);
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
