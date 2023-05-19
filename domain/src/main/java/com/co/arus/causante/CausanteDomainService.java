package com.co.arus.causante;

import com.co.arus.causante.events.*;
import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.causante.factories.IRentaFactory;
import com.co.arus.commons.DomainEvent;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;

import java.util.Date;
import java.util.List;

public class CausanteDomainService implements ICausanteDomainService{

    @Override
    public Causante consultarCausante(Documento documento,List<DomainEvent> domainEvents) {
        return (Causante) new Causante(documento).from(domainEvents);
    }

    @Override
    public CausanteCreado crearCausante(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero, IBeneficiarioFactory beneficiarioFactory, IRentaFactory rentaFactory) {
        Causante causante = new Causante(documento, nombre, fechaNacimiento, genero, beneficiarioFactory, rentaFactory);
        CausanteCreado causanteCreado = new CausanteCreado(causante);
        causanteCreado.getCausante().addDomainEvent(causanteCreado);
        return causanteCreado;
    }

    @Override
    public BeneficiarioAsociado asociarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory) {
        causante.asociarBeneficiario(beneficiarioFactory);
        BeneficiarioAsociado beneficiarioAsociado = new BeneficiarioAsociado(causante);
        beneficiarioAsociado.getCausante().addDomainEvent(beneficiarioAsociado);
        return beneficiarioAsociado;
    }

    @Override
    public BeneficiarioActualizado actualizarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory) {
        causante.actualizarBeneficiario(beneficiarioFactory);
        BeneficiarioActualizado beneficiarioActualizado = new BeneficiarioActualizado(causante);
        beneficiarioActualizado.getCausante().addDomainEvent(beneficiarioActualizado);
        return beneficiarioActualizado;
    }

    @Override
    public BeneficiarioEliminado eliminarBeneficiario(Causante causante) {
        causante.eliminarBeneficiario();
        BeneficiarioEliminado beneficiarioEliminado = new BeneficiarioEliminado(causante);
        beneficiarioEliminado.getCausante().addDomainEvent(beneficiarioEliminado);
        return beneficiarioEliminado;
    }

    @Override
    public CausanteActualizado actualizarCausante(Causante causante, Nombre nombre, Date fechaNacimiento, Genero genero) {
        causante.actualizarCausante(nombre, fechaNacimiento, genero);
        CausanteActualizado causanteActualizado = new CausanteActualizado(causante);
        causanteActualizado.getCausante().addDomainEvent(causanteActualizado);
        return causanteActualizado;
    }

    @Override
    public CausanteEliminado eliminarCausante(Causante causante) {
        CausanteEliminado causanteEliminado = new CausanteEliminado(causante);
        causanteEliminado.getCausante().addDomainEvent(causanteEliminado);
        return causanteEliminado;
    }
}
