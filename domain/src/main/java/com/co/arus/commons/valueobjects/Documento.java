package com.co.arus.commons.valueobjects;

import com.co.arus.commons.BaseId;
import com.co.arus.commons.enums.TipoDocumento;


public class Documento extends BaseId<String> {
    private final TipoDocumento tipoDocumento;
    public Documento(TipoDocumento tipoDocumento, String id) {
        super(id);
        this.tipoDocumento = tipoDocumento;
    }

    public TipoDocumento getTipoDocumento(){
        return this.tipoDocumento;
    }
}
