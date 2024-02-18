package com.codigo.feign.service;

import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.ResponseBase;

public interface PersonaService {
    ResponseBase crearPersona(PersonaRequest personaRequest);

    ResponseBase getInfoReniec(String numero);
}
