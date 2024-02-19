package com.tecsup.mstaniguchi.infraestructure.repository;

import com.tecsup.mstaniguchi.infraestructure.entity.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Long> {
    TipoPersona findByCodTipo(@Param("codTipo") String codTipo);
}
