package com.co.arus.data;

import com.co.arus.causante.valueobjects.Salario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "renta")
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RentaData {
    @Id
    private String id;
    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "salario"))
    private Salario salario;
    @Column(name = "meses_cotizando")
    private Integer mesesCotizando;
}
