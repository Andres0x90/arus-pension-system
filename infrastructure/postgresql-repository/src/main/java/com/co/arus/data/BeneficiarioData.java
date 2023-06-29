package com.co.arus.data;

import com.co.arus.causante.enums.TipoBeneficiario;
import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.valueobjects.Nombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "beneficiario")
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioData {
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Id
    private String documento;
    @Embedded
    private Nombre nombre;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String genero;
    @Column(name = "tipo_beneficiario")
    private String tipoBeneficiario;
    private boolean estudiante;
    private boolean dependiente;
}
