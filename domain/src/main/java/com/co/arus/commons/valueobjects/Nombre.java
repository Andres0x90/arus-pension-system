package com.co.arus.commons.valueobjects;

import com.co.arus.commons.exceptions.DomainException;

public class Nombre {
    private  String nombres;
    private  String apellidos;

    public Nombre() {
    }

    public Nombre(String nombres, String apellidos) {
        this.nombres = validarNombres(nombres);
        this.apellidos = validarApellidos(apellidos);
    }

    private String validarApellidos(String apellidos) {
        if(!apellidos.matches("^[^0-9]{1,50}$"))
            throw new DomainException(DomainException.APELLIDOS_INVALIDO);

        return apellidos;
    }

    private String validarNombres(String nombres) {
        if(!nombres.matches("^[^0-9]{1,50}$"))
            throw new DomainException(DomainException.NOMBRES_INVALID0);

        return nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
}
