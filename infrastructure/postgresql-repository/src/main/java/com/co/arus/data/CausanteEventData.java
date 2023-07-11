package com.co.arus.data;

import com.co.arus.commons.valueobjects.Nombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "causante")
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CausanteEventData {
    @Id
    private String eventId;
    private Date eventDate;
    private String type;
    private String tipoDocumento;
    private String documento;
    @Embedded
    private Nombre nombre;
    private Date fechaNacimiento;
    private String genero;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiario")
    private BeneficiarioData beneficiario;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "renta_id")
    private RentaData renta;
}
