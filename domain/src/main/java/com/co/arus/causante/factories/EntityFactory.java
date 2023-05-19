package com.co.arus.causante.factories;

import com.co.arus.causante.entities.Beneficiario;

public interface EntityFactory<Entity> {
     Entity construir();
}
