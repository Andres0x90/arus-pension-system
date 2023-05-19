package com.co.arus.causante.entities;

import com.co.arus.causante.enums.TipoBeneficiario;
import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.commons.Entity;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;

public class Beneficiario extends Entity<Documento> {
    private Nombre nombre;
    private Date fechaNacimiento;
    private Genero genero;
    private TipoBeneficiario tipoBeneficiario;
    private boolean estudiante;
    private boolean dependiente;

    public Beneficiario(Documento documento, Nombre nombre, Date fechaNacimiento,
                        Genero genero, TipoBeneficiario tipoBeneficiario,
                        boolean estudiante, boolean dependiente) {
        super(documento);
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.tipoBeneficiario = tipoBeneficiario;
        this.estudiante = estudiante;
        this.dependiente = dependiente;
    }

    public void actualizar(IBeneficiarioFactory beneficiarioFactory){
        Beneficiario beneficiario = beneficiarioFactory.construir();
        this.nombre = beneficiario.nombre;
        this.fechaNacimiento = beneficiario.fechaNacimiento;
        this.genero = beneficiario.genero;
        this.tipoBeneficiario = beneficiario.tipoBeneficiario;
        this.estudiante = beneficiario.estudiante;
        this.dependiente = beneficiario.dependiente;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Date fechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero genero() {
        return genero;
    }

    public TipoBeneficiario tipoBeneficiario() {
        return tipoBeneficiario;
    }

    public boolean isEstudiante() {
        return estudiante;
    }

    public boolean isDependiente() {
        return dependiente;
    }
}
