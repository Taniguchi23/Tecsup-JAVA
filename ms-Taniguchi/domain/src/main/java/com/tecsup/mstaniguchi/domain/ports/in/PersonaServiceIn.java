package com.tecsup.mstaniguchi.domain.ports.in;

import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceIn {
    PersonaDTO crearPersonaIn(RequestPersona requestPersona);
    Optional<PersonaDTO> obtenerPersonaIn(String dni);
    List<PersonaDTO> obtenerTodosIn();
    PersonaDTO actualizarIn(Long id, RequestPersona requestPersona);
    PersonaDTO deleteIn(Long id);
}