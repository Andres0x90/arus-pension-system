package com.co.arus.mapper;

import com.co.arus.causante.factories.IBeneficiarioFactory;
import com.co.arus.causante.factories.IRentaFactory;
import com.co.arus.commands.BeneficiarioCommand;
import com.co.arus.commands.RentaCommand;

public interface Mapper {
    IBeneficiarioFactory mapToFactory(BeneficiarioCommand beneficiarioCommand);
    IRentaFactory mapToFactory(RentaCommand rentaCommand);
}
