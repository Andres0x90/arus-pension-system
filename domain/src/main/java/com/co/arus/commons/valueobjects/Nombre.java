package com.co.arus.commons.valueobjects;

public class Nombre {
    private final String nombres;
    private final String apellidos;

    public Nombre(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
}
