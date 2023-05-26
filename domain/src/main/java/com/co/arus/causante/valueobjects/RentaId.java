package com.co.arus.causante.valueobjects;

import com.co.arus.causante.factories.BeneficiarioFactory;
import com.co.arus.commons.BaseId;

import java.util.UUID;

public class RentaId extends BaseId<UUID> {

    public RentaId() {
    }

    public RentaId(UUID id) {
        super(id);
    }

}
