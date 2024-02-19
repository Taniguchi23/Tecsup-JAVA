package com.tecsup.mstaniguchi.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDTO {
    private Long idPersona;
    private String numDocu;
    private String nombres;
    private String apePat;
    private String apeMat;
    private Integer estado;
    private String tipoPer;
    private String tipoDoc;
}
