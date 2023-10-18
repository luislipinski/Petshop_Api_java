package com.lipinski.petshop_api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeception extends RuntimeException{
    public ResourceNotFoundExeception(String message) {
        super(message);
    }
}
