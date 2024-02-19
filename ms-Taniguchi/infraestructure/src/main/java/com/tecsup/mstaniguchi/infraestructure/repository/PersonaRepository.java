package com.tecsup.mstaniguchi.infraestructure.repository;

import com.tecsup.mstaniguchi.infraestructure.entity.Persona;
import com.tecsup.mstaniguchi.infraestructure.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNumDocu(@Param("numDocu") String numDocu);

    List<Persona> findByEstado(@Param("estado") int estado);
}
