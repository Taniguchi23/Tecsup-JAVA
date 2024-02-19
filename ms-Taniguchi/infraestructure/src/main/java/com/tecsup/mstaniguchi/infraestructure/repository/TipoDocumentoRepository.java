package com.tecsup.mstaniguchi.infraestructure.repository;

import com.tecsup.mstaniguchi.infraestructure.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
    TipoDocumento findByCodTipo(@Param("codTipo") String codTipo);
}
