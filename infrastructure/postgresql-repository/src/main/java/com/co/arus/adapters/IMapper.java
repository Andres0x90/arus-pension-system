package com.co.arus.adapters;

import com.co.arus.causante.factories.BeneficiarioFactory;
import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.causante.factories.IRentaFactory;
import com.co.arus.causante.factories.RentaFactory;
import com.co.arus.causante.valueobjects.Salario;
import com.co.arus.commands.BeneficiarioCommand;
import com.co.arus.commands.RentaCommand;
import com.co.arus.commons.valueobjects.Documento;
import com.co.arus.commons.valueobjects.Nombre;
import org.springframework.stereotype.Component;

@Component
public class IMapper implements com.co.arus.mapper.IMapper
 {
    @Override
    public IBeneficiarioFactory mapToFactory(BeneficiarioCommand beneficiarioCommand) {
        return BeneficiarioFactory.builder()
                .id(new Documento(beneficiarioCommand.getTipoDocumento(), beneficiarioCommand.getDocumento()))
                .nombre(new Nombre(beneficiarioCommand.getNombres(), beneficiarioCommand.getApellidos()))
                .fechaNacimiento(beneficiarioCommand.getFechaNacimiento())
                .genero(beneficiarioCommand.getGenero())
                .tipoBeneficiario(beneficiarioCommand.getTipoBeneficiario())
                .estudiante(beneficiarioCommand.isEstudiante())
                .dependiente(beneficiarioCommand.isDependiente());
    }

    @Override
    public IRentaFactory mapToFactory(RentaCommand rentaCommand) {
        return RentaFactory.builder()
                .fechaSolicitud(rentaCommand.getFechaSolicitud())
                .salario(new Salario(rentaCommand.getSalario()))
                .mesesCotizando(rentaCommand.getMesesCotizando());
    }
}
