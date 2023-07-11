package com.co.arus.crud;

import com.co.arus.data.CausanteEventData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CausanteEventCrudRepository extends JpaRepository<CausanteEventData, String> {
    List<CausanteEventData> findByDocumento(String documento);
}
