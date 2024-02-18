package com.semana7.swagger.entity;

import javax.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "autor")
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    @Column(name = "tipo_doc")
    private String tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidos;
    private String email;
    private Integer estado;
    private String userCreate;
    private Timestamp dateCreate;
    private String userModif;
    private Timestamp dateModif;
    private String userDelete;
    private Timestamp dateDelete;
}
