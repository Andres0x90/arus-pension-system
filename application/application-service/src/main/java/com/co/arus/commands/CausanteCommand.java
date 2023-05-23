package com.co.arus.commands;

import com.co.arus.commons.enums.Genero;
import com.co.arus.commons.enums.TipoDocumento;
import com.co.arus.commons.valueobjects.Nombre;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Builder(toBuilder = true)
@Data
public class CausanteCommand {
    private final TipoDocumento tipoDocumento;
    @Pattern(regexp = "^[a-zA-Z0-9]{1,30}$", message = "El campo 'documento' debe ser alfanumérico y tener máximo 30 caracteres")
    private final String documento;
    @Pattern(regexp = "^[^0-9]{1,50}$", message = "El campo 'nombres' no debe permitir números y la longitud máxima es de 50 caracteres")
    private final String nombres;
    @Pattern(regexp = "^[^0-9]{1,50}$", message = "El campo 'apellidos' no debe permitir números y la longitud máxima es de 50 caracteres")
    private final String apellidos;
    private final Date fechaNacimiento;
    private final Genero genero;
    private final BeneficiarioCommand beneficiario;
    private final RentaCommand renta;
}
