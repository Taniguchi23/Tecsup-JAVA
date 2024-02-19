package com.tecsup.mstaniguchi.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tipo_persona")
public class TipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_persona")
    public Integer idTipoPersona;
    public String codTipo;
    public String descTipo;
    public Integer estado;
    public String usuaCrea;
    public Timestamp dateCreate;
    public String usuaModif;
    public Timestamp dateModif;
    public String usuaDelet;
    public Timestamp dateDelet;
}
