package com.tecsup.mstaniguchi.infraestructure.rest.persona;

import com.tecsup.mstaniguchi.domain.aggregates.response.ResponseReniec;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "persona-reniec", url = "https://api.apis.net.pe/v2/reniec/")
public interface PersonaReniec {
    @GetMapping("/dni")
    ResponseReniec getInfoReniec(@RequestParam("numero") String numero,
                                 @RequestHeader("Authorization") String authorizationHeader);
}
