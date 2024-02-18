package com.codigo.feign.service.impl;

import com.codigo.feign.aggregates.constans.Constants;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.ResponseBase;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.feignclient.SunatClient;
import com.codigo.feign.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private SunatClient sunatClient;

    @Value("${token.api}")
    private String tokenApi;


    @Override
    public ResponseBase getInfoSunat(String numero) {
        SunatResponse response = getExecution(numero);
        if (response != null){
            return  new ResponseBase(Constants.CODE_SUCCESS, Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new ResponseBase(Constants.CODE_ERROR, Constants.MESS_ERROR, Optional.empty());
    }

    private SunatResponse getExecution(String numero){
        String authorization = "Bearer "+ tokenApi;
        return sunatClient.getInfo(numero,authorization);
    }
}
