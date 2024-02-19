package com.tecsup.mstaniguchi.domain.ports.out;

import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {
    PersonaDTO crearPersonaOut(RequestPersona requestPersona);
    Optional<PersonaDTO> obtenerPersonaOut(String dni);
    List<PersonaDTO> obtenerTodosOut();
    PersonaDTO actualizarOut(Long id, RequestPersona requestPersona);
    PersonaDTO deleteOut(Long id);
}
