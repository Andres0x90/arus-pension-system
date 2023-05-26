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

    public CausanteDomainService() {
    }

    @Override
    public Causante consultarCausante(Documento documento,List<DomainEvent> domainEvents) {
        return (Causante) new Causante(documento).from(domainEvents);
    }

    @Override
    public CausanteCreado crearCausante(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero) {
        return new CausanteCreado(documento, nombre, fechaNacimiento, genero, null, null);
    }

    @Override
    public BeneficiarioAsociado asociarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory) {
        causante.asociarBeneficiario(beneficiarioFactory);
        BeneficiarioAsociado beneficiarioAsociado = new BeneficiarioAsociado(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(beneficiarioAsociado);
        return beneficiarioAsociado;
    }

    @Override
    public RentaCreada crearRenta(Causante causante, IRentaFactory rentaFactory) {
        causante.crearRenta(rentaFactory);
        RentaCreada rentaCreada = new RentaCreada(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(rentaCreada);
        return rentaCreada;
    }

    @Override
    public BeneficiarioActualizado actualizarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory) {
        causante.actualizarBeneficiario(beneficiarioFactory);
        BeneficiarioActualizado beneficiarioActualizado = new BeneficiarioActualizado(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(beneficiarioActualizado);
        return beneficiarioActualizado;
    }

    @Override
    public BeneficiarioEliminado eliminarBeneficiario(Causante causante) {
        causante.eliminarBeneficiario();
        BeneficiarioEliminado beneficiarioEliminado = new BeneficiarioEliminado(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(beneficiarioEliminado);
        return beneficiarioEliminado;
    }

    @Override
    public CausanteActualizado actualizarCausante(Causante causante, Nombre nombre, Date fechaNacimiento, Genero genero) {
        causante.actualizarCausante(nombre, fechaNacimiento, genero);
        CausanteActualizado causanteActualizado = new CausanteActualizado(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(causanteActualizado);
        return causanteActualizado;
    }

    @Override
    public CausanteEliminado eliminarCausante(Causante causante) {
        CausanteEliminado causanteEliminado = new CausanteEliminado(causante.getId(), causante.getNombre(), causante.getFechaNacimiento(), causante.getGenero(), causante.getBeneficiario(), causante.getRenta());
        causante.addDomainEvent(causanteEliminado);
        return causanteEliminado;
    }
}
