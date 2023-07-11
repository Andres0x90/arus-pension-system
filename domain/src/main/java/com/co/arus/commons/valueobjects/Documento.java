package com.co.arus.commons.valueobjects;

import com.co.arus.commons.BaseId;
import com.co.arus.commons.enums.TipoDocumento;
import com.co.arus.commons.exceptions.DomainException;


public class Documento extends BaseId<String> {
    private TipoDocumento tipoDocumento;

    public Documento() {
    }

    public Documento(TipoDocumento tipoDocumento, String id) {
        super(validarDocumento(id));
        this.tipoDocumento = tipoDocumento;
    }

    private static String validarDocumento(String id) {
        if (!id.matches("^[a-zA-Z0-9]{1,30}$"))
            throw new DomainException(DomainException.DOCUMENTO_INVALIDO);

        return id;
    }

    public TipoDocumento getTipoDocumento(){
        return this.tipoDocumento;
    }
}
