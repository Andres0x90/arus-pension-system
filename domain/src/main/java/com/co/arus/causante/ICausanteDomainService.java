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

public interface ICausanteDomainService {
    Causante consultarCausante(Documento documento, List<DomainEvent>domainEvents);
    CausanteCreado crearCausante(Documento documento, Nombre nombre, Date fechaNacimiento, Genero genero);
    BeneficiarioAsociado asociarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory);
    RentaCreada crearRenta(Causante causante, IRentaFactory rentaFactory);
    BeneficiarioActualizado actualizarBeneficiario(Causante causante, IBeneficiarioFactory beneficiarioFactory);
    BeneficiarioEliminado eliminarBeneficiario(Causante causante);
    CausanteActualizado actualizarCausante(Causante causante,Nombre nombre, Date fechaNacimiento, Genero genero);
    CausanteEliminado eliminarCausante(Causante causante);
}
