package com.co.arus.crud;

import com.co.arus.data.CausanteEventData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausanteEventCrudRepository extends JpaRepository<CausanteEventData, String> {
}
