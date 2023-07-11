package com.co.arus.mapper;

import com.co.arus.causante.entities.Beneficiario;
import com.co.arus.causante.entities.Renta;
import com.co.arus.causante.enums.TipoBeneficiario;
import com.co.arus.causante.events.CausanteDomainEvent;
import com.co.arus.causante.valueobjects.RentaId;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.enums.TipoDocumento;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.data.BeneficiarioData;
import com.co.arus.data.CausanteEventData;
import com.co.arus.data.RentaData;

import java.util.Optional;
import java.util.UUID;

public class Mapper {
    public static CausanteEventData toData(CausanteDomainEvent causanteDomainEvent){
        return CausanteEventData.builder()
                .eventId(UUID.randomUUID().toString())
                .eventDate(causanteDomainEvent.getDate())
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
        return new CausanteDomainEvent(causanteEventData.getEventId(), causanteEventData.getType(),
                causanteEventData.getEventDate(),
                new Documento(TipoDocumento.valueOf(causanteEventData.getTipoDocumento()), causanteEventData.getDocumento()),
                causanteEventData.getNombre(), causanteEventData.getFechaNacimiento(), Genero.valueOf(causanteEventData.getGenero()),
                causanteEventData.getBeneficiario() != null?toEntity(causanteEventData.getBeneficiario()):null,
                causanteEventData.getRenta() != null?toEntity(causanteEventData.getRenta()):null);
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

    public static Beneficiario toEntity(BeneficiarioData beneficiarioData){
        return new Beneficiario(new Documento(TipoDocumento.valueOf(beneficiarioData.getTipoDocumento()), beneficiarioData.getDocumento())
        , beneficiarioData.getNombre(), beneficiarioData.getFechaNacimiento(), Genero.valueOf(beneficiarioData.getGenero())
        , TipoBeneficiario.valueOf(beneficiarioData.getTipoBeneficiario()), beneficiarioData.isEstudiante(), beneficiarioData.isDependiente());
    }

    public static RentaData toData(Renta renta){
        return RentaData.builder()
                .id(renta.getId().getId().toString())
                .fechaSolicitud(renta.getFechaSolicitud())
                .salario(renta.getSalario())
                .mesesCotizando(renta.getMesesCotizando())
                .build();
    }

    public static Renta toEntity(RentaData rentaData){
        return new Renta(new RentaId(UUID.fromString(rentaData.getId())), rentaData.getFechaSolicitud(), rentaData.getSalario(),
                rentaData.getMesesCotizando());
    }
}
