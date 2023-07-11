package com.co.arus.commands;

import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CausanteCommand {
    private  TipoDocumento tipoDocumento;
    private  String documento;
    private  String nombres;
    private  String apellidos;
    private  Date fechaNacimiento;
    private  Genero genero;
    private  BeneficiarioCommand beneficiario;
    private  RentaCommand renta;
}
