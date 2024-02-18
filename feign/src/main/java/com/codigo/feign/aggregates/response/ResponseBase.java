package com.codigo.feign.aggregates.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ResponseBase{
    private int code;
    private String message;
    private Optional data;
}
