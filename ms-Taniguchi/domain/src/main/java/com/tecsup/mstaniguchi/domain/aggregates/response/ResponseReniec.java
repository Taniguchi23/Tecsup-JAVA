package com.tecsup.mstaniguchi.domain.aggregates.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseReniec {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificador;
}
