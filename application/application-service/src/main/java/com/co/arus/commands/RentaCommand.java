package com.co.arus.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentaCommand {
    private Date fechaSolicitud;
    private Integer salario;
    private Integer mesesCotizando;
}
