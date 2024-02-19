package com.tecsup.mstaniguchi.application.controller;

import com.tecsup.mstaniguchi.domain.aggregates.dto.PersonaDTO;
import com.tecsup.mstaniguchi.domain.aggregates.request.RequestPersona;
import com.tecsup.mstaniguchi.domain.ports.in.PersonaServiceIn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "API-PERSONA",
                version = "1.0",
                description = "Mantenimiento de una Persona"
        )
)
@RestController
@RequestMapping("/persona")
@Slf4j
@RequiredArgsConstructor
public class PersonaController {


    private final PersonaServiceIn personaServiceIn;

    @Operation(summary = "Crea una Persona")
    @PostMapping()
    public ResponseEntity<PersonaDTO> save(@RequestBody RequestPersona requestPersona){
        log.error("hola");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.crearPersonaIn(requestPersona));

    }

    @Operation(summary = "Obtiene una Persona por id")
    @GetMapping("/{dni}")
    public ResponseEntity<PersonaDTO> get(@PathVariable String dni){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.obtenerPersonaIn(dni).get());

    }

    @Operation(summary = "Obtiene todas las Personas")
    @GetMapping("/activas")
    public ResponseEntity<List<PersonaDTO>> getall(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.obtenerTodosIn());

    }

    @Operation(summary = "Actualizar una Persona")
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Long id,@RequestBody RequestPersona requestPersona){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.actualizarIn(id,requestPersona));

    }

    @Operation(summary = "Eliminar una Persona")
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.deleteIn(id));

    }

}
