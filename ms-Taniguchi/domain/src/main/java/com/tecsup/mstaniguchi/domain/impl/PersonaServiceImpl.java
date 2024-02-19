package com.tecsup.mstaniguchi.domain.impl;

import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.domain.aggregates.request.RequestPersona;
import com.tecsup.mstaniguchi.domain.ports.in.PersonaServiceIn;
import com.tecsup.mstaniguchi.domain.ports.out.PersonaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaServiceIn {



    private final   PersonaServiceOut personaServiceOut;
    @Override
    public PersonaDTO crearPersonaIn(RequestPersona requestPersona) {
        return personaServiceOut.crearPersonaOut(requestPersona);
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaIn(String dni) {
        return personaServiceOut.obtenerPersonaOut(dni);
    }

    @Override
    public List<PersonaDTO> obtenerTodosIn() {
        return personaServiceOut.obtenerTodosOut();
    }

    @Override
    public PersonaDTO actualizarIn(Long id, RequestPersona requestPersona) {
        return personaServiceOut.actualizarOut(id, requestPersona);
    }

    @Override
    public PersonaDTO deleteIn(Long id) {
        return personaServiceOut.deleteOut(id);
    }
}
