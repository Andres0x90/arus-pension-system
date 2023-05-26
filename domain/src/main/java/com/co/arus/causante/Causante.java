package com.co.arus.causante;

import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.events.CausanteDomainEvent;
import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.causante.factories.IRentaFactory;
import com.co.arus.commons.Aggregate;
import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;

public class Causante extends Aggregate<Documento> {

    private Nombre nombre;
    private Date fechaNacimiento;
    private Genero genero;
    private Beneficiario beneficiario;
    private Renta renta;

    public Causante(Documento documento) {
        super(documento);
    }

    public Causante(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero) {
        super(documento);
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Causante(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero, IBeneficiarioFactory beneficiarioFactory, IRentaFactory rentaFactory) {
        super(documento);
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.beneficiario = beneficiarioFactory.construir();
        this.renta = rentaFactory.construir();
    }

    public void asociarBeneficiario(IBeneficiarioFactory beneficiarioFactory){
        this.beneficiario = beneficiarioFactory.construir();
    }

    public void crearRenta(IRentaFactory rentaFactory){
        this.renta = rentaFactory.construir();
    }

    public void actualizarBeneficiario(IBeneficiarioFactory beneficiarioFactory){
        this.beneficiario.actualizar(beneficiarioFactory);
    }

    public void eliminarBeneficiario(){
        this.beneficiario = null;
    }

    public void actualizarCausante(Nombre nombre, Date fechaNacimiento, Genero genero){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    @Override
    protected void applyDomainEvents(DomainEvent domainEvent) {
        CausanteDomainEvent causanteDomainEvent = (CausanteDomainEvent) domainEvent;
        this.id = causanteDomainEvent.getDocumento();
        this.nombre = causanteDomainEvent.getNombre();
        this.fechaNacimiento = causanteDomainEvent.getFechaNacimiento();
        this.genero = causanteDomainEvent.getGenero();
        this.beneficiario = causanteDomainEvent.getBeneficiario();
        this.renta = causanteDomainEvent.getRenta();
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
