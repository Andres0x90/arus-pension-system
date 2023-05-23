package com.co.arus.commands;

import com.co.arus.causante.valueobjects.Salario;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder(toBuilder = true)
@Data
public class RentaCommand {
    private Date fechaSolicitud;
    private Salario salario;
    private Integer mesesCotizando;
}
