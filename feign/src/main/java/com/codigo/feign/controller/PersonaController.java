package com.codigo.feign.controller;

import com.codigo.feign.aggregates.response.ResponseBase;
import com.codigo.feign.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/persona")
@Slf4j
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseBase getInfoReniec(@RequestParam String numero){
        log.error("hola");
        log.error(numero);
        return  personaService.getInfoReniec(numero);
    }

    @GetMapping("/prueba")
    public String prueba (){
        return "sss";
    }

}
