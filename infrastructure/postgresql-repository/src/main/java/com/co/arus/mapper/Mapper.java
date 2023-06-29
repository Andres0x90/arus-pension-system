package com.co.arus.mapper;

import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.events.CausanteDomainEvent;
import com.co.arus.data.BeneficiarioData;
import com.co.arus.data.CausanteEventData;
import com.co.arus.data.RentaData;

import java.util.Optional;
import java.util.UUID;

public class Mapper {
    public static CausanteEventData toData(CausanteDomainEvent causanteDomainEvent){
        return CausanteEventData.builder()
                .eventId(UUID.randomUUID().toString())
                .type(causanteDomainEvent.getType())
                .tipoDocumento(causanteDomainEvent.getDocumento().getTipoDocumento().name())
                .documento(causanteDomainEvent.getDocumento().getId())
                .nombre(causanteDomainEvent.getNombre())
                .fechaNacimiento(causanteDomainEvent.getFechaNacimiento())
                .genero(causanteDomainEvent.getGenero().name())
                .beneficiario(causanteDomainEvent.getBeneficiario() != null?toData(causanteDomainEvent.getBeneficiario()):null)
                .renta(causanteDomainEvent.getRenta() != null? toData(causanteDomainEvent.getRenta()):null)
                .build();
    }

    public static CausanteDomainEvent toEntity(CausanteEventData causanteEventData){
        return new CausanteDomainEvent("");
    }

    public static BeneficiarioData toData(Beneficiario beneficiario){
        return BeneficiarioData.builder()
                .tipoDocumento(beneficiario.getId().getTipoDocumento().name())
                .documento(beneficiario.getId().getId())
                .nombre(beneficiario.getNombre())
                .fechaNacimiento(beneficiario.getFechaNacimiento())
                .genero(beneficiario.getGenero().name())
                .tipoBeneficiario(beneficiario.getTipoBeneficiario().name())
                .estudiante(beneficiario.isEstudiante())
                .dependiente(beneficiario.isDependiente())
                .build();
    }

    public static RentaData toData(Renta renta){
        return RentaData.builder()
                .id(renta.getId().getId().toString())
                .fechaSolicitud(renta.getFechaSolicitud())
                .salario(renta.getSalario())
                .mesesCotizando(renta.getMesesCotizando())
                .build();
    }
}
