package com.tecsup.mstaniguchi.infraestructure.adapters;

import com.tecsup.mstaniguchi.domain.aggregates.constants.Constants;
import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.domain.aggregates.request.RequestPersona;
import com.tecsup.mstaniguchi.domain.aggregates.response.ResponseReniec;
import com.tecsup.mstaniguchi.domain.ports.out.PersonaServiceOut;
import com.tecsup.mstaniguchi.infraestructure.entity.Persona;
import com.tecsup.mstaniguchi.infraestructure.entity.TipoDocumento;
import com.tecsup.mstaniguchi.infraestructure.entity.TipoPersona;
import com.tecsup.mstaniguchi.infraestructure.mapper.PersonaMapper;
import com.tecsup.mstaniguchi.infraestructure.repository.PersonaRepository;
import com.tecsup.mstaniguchi.infraestructure.repository.TipoDocumentoRepository;
import com.tecsup.mstaniguchi.infraestructure.repository.TipoPersonaRepository;
import com.tecsup.mstaniguchi.infraestructure.rest.persona.PersonaReniec;
import com.tecsup.mstaniguchi.infraestructure.util.Util;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {

    private final PersonaReniec reniec;
    private final PersonaRepository personaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoPersonaRepository tipoPersonaRepository;
    private final PersonaMapper personaMapper;
    private final Util util;

    @Value("${token.api}")
    private String tokenApi;
    @Override
    public PersonaDTO crearPersonaOut(RequestPersona requestPersona) {
        ResponseReniec datosReniec = getExecutionReniec(requestPersona.getNumDoc());
        personaRepository.save(getEntity(datosReniec,requestPersona));
        return personaMapper.mapToDto(getEntity(datosReniec,requestPersona));
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaOut(String dni) {
        PersonaDTO dto = personaMapper.mapToDto(personaRepository.findByNumDocu(dni));
        if (dto != null){
           return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public List<PersonaDTO> obtenerTodosOut() {
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        List<Persona> personas = personaRepository.findByEstado(1);
        for(Persona persona : personas){
            PersonaDTO personaDTO = personaMapper.mapToDto(persona);
            personaDTOList.add(personaDTO);
        }
        return personaDTOList;
    }

    @Override
    public PersonaDTO actualizarOut(Long id, RequestPersona requestPersona) {
        boolean existe = personaRepository.existsById(id);
        if(existe){
            Optional<Persona> entity = personaRepository.findById(id);
            ResponseReniec responseReniec = getExecutionReniec(requestPersona.getNumDoc());
            personaRepository.save(getEntityUpdate(responseReniec,entity.get(), requestPersona));
            return personaMapper.mapToDto(getEntityUpdate(responseReniec,entity.get(), requestPersona));
        }
        return null;

    }

    @Override
    public PersonaDTO deleteOut(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        if (persona != null){
            persona.setEstado(0);
            personaRepository.save(persona);
            PersonaDTO dto = personaMapper.mapToDto(persona);
            return dto;
        }

        return null;
    }

    public ResponseReniec getExecutionReniec(String numero){
        String authorization = "Bearer "+ tokenApi;
        ResponseReniec responseReniec = reniec.getInfoReniec(numero,authorization);
        return  responseReniec;
    }

    private Persona getEntity(ResponseReniec reniec, RequestPersona requestPersona){
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestPersona.getTipoDoc());
        TipoPersona tipoPersona = tipoPersonaRepository.findByCodTipo(requestPersona.getTipoPer());
        Persona entity = new Persona();
        entity.setNumDocu(reniec.getNumeroDocumento());
        entity.setNombres(reniec.getNombres());
        entity.setApePat(reniec.getApellidoPaterno());
        entity.setApeMat(reniec.getApellidoMaterno());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        entity.setTipoDocumento(tipoDocumento);
        entity.setTipoPersona(tipoPersona);
        return entity;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }

    private Persona getEntityUpdate(ResponseReniec reniec, Persona personaActualizar, RequestPersona requestPersona ){
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestPersona.getTipoDoc());
        TipoPersona tipoPersona = tipoPersonaRepository.findByCodTipo(requestPersona.getTipoPer());
        personaActualizar.setNombres(reniec.getNombres());
        personaActualizar.setNumDocu(reniec.getNumeroDocumento());
        personaActualizar.setApePat(reniec.getApellidoPaterno());
        personaActualizar.setApeMat(reniec.getApellidoMaterno());
        personaActualizar.setTipoPersona(tipoPersona);
        personaActualizar.setTipoDocumento(tipoDocumento);
        personaActualizar.setUsuaModif(Constants.AUDIT_ADMIN);
        personaActualizar.setDateModif(getTimestamp());
        return personaActualizar;
    }
}
