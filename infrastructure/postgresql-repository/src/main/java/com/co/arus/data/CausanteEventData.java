package com.co.arus.data;

import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Documento;
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
    private String type;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "documento")
    private String documento;
    @Embedded
    private Nombre nombre;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String genero;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiario")
    private BeneficiarioData beneficiario;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private RentaData renta;
}
