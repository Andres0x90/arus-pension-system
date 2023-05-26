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
    @Pattern(regexp = "^[a-zA-Z0-9]{1,30}$", message = "El campo 'documento' debe ser alfanumérico y tener máximo 30 caracteres")
    private  String documento;
    @Pattern(regexp = "^[^0-9]{1,50}$", message = "El campo 'nombres' no debe permitir números y la longitud máxima es de 50 caracteres")
    private  String nombres;
    @Pattern(regexp = "^[^0-9]{1,50}$", message = "El campo 'apellidos' no debe permitir números y la longitud máxima es de 50 caracteres")
    private  String apellidos;
    private  Date fechaNacimiento;
    private  Genero genero;
    private  BeneficiarioCommand beneficiario;
    private  RentaCommand renta;
}
