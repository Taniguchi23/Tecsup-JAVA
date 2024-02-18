package com.codigo.feign.service.impl;

import com.codigo.feign.aggregates.constans.Constants;
import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.ResponseBase;
import com.codigo.feign.feignclient.ReniecClient;
import com.codigo.feign.repository.PersonaRepository;
import com.codigo.feign.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private final ReniecClient reniecClient;

    public PersonaServiceImpl(ReniecClient reniecClient){
        this.reniecClient= reniecClient;
    }

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public ResponseBase crearPersona(PersonaRequest personaRequest) {


        return null;
    }

    @Override
    public ResponseBase getInfoReniec(String numero) {
        ReniecResponse response = getExecution(numero);
        if (response != null){
            return  new ResponseBase(Constants.CODE_SUCCESS, Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new ResponseBase(Constants.CODE_ERROR, Constants.MESS_ERROR, Optional.empty());
    }

    private ReniecResponse getExecution(String numero){
        String authorization = "Bearer "+ tokenApi;
        return reniecClient.getInfo(numero,authorization);
    }

}
