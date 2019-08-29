package com.qfedu.dt.common;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException(AuthorizationException ex){
        return "noPermission";
    }
}
