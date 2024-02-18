package com.semana7.swagger.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AutorRequest {
    private Long idAutor;
    private String tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidos;
    private String email;
}
