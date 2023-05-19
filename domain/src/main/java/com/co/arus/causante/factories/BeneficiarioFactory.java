package com.co.arus.causante.factories;

import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.enums.TipoBeneficiario;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;

public class BeneficiarioFactory implements IBeneficiarioFactory {
    private Documento id;
    private Nombre nombre;
    private Date fechaNacimiento;
    private Genero genero;
    private TipoBeneficiario tipoBeneficiario;
    private boolean estudiante;
    private boolean dependiente;

    public BeneficiarioFactory() {
    }


    public static BeneficiarioFactory builder() {
        return new BeneficiarioFactory();
    }

    public BeneficiarioFactory id(Documento id) {
        this.id = id;
        return this;
    }

    public BeneficiarioFactory nombre(Nombre nombre) {
        this.nombre = nombre;
        return this;
    }

    public BeneficiarioFactory fechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public BeneficiarioFactory genero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public BeneficiarioFactory tipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
        return this;
    }

    public BeneficiarioFactory estudiante(boolean estudiante) {
        this.estudiante = estudiante;
        return this;
    }

    public BeneficiarioFactory dependiente(boolean dependiente) {
        this.dependiente = dependiente;
        return this;
    }

    @Override
    public Beneficiario construir() {
        return new Beneficiario(id, nombre, fechaNacimiento, genero, tipoBeneficiario, estudiante, dependiente);
    }

}
