package com.codigo.feign.service;

import com.codigo.feign.aggregates.response.ResponseBase;

public interface EmpresaService {
    ResponseBase getInfoSunat(String numero);
}
