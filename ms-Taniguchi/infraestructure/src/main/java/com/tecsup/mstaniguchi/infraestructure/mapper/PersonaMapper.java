package com.tecsup.mstaniguchi.infraestructure.mapper;

import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.infraestructure.entity.Persona;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class PersonaMapper {
 //   private static final ModelMapper modelMapper = new ModelMapper();

//    static {
//        configureMappings();
//    }
//
//    private static void configureMappings() {
//        modelMapper.addMappings(new PropertyMap<Persona, PersonaDTO>() {
//            @Override
//            protected void configure() {
//                map().setTipoDoc(source.getTipoDocumento().getCodTipo());
//            }
//        });
//    }
//    public static PersonaDTO mapToDto(Persona entity){
//        return modelMapper.map(entity, PersonaDTO.class);
//    }
    public static PersonaDTO mapToDto(Persona persona) {
        ModelMapper modelMapper = new ModelMapper();
        PersonaDTO personaDTO = modelMapper.map(persona, PersonaDTO.class);
        if (persona.getTipoPersona() != null) {
            personaDTO.setTipoPer(persona.getTipoPersona().getCodTipo());
            personaDTO.setTipoDoc(persona.getTipoDocumento().getCodTipo());

        }
        return personaDTO;
    }
//    public Persona mapToEntity(PersonaDTO personaDTO){
//        return modelMapper.map(personaDTO, Persona.class);
//    }
}
