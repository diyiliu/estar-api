package com.tiza.web.controller.exc;

import com.tiza.web.model.RespResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: GlobalExceptionHandler
 * Author: DIYILIU
 * Update: 2017-12-07 10:28
 */

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noHandlerFound() {

        return "404";
    }

    @ExceptionHandler(Exception.class)
    public RespResult defaultErrorHandler(HttpServletRequest request, Exception e) {
        RespResult result = new RespResult();
        result.setRet(500);
        result.setMsg(e.getMessage());

        return result;
    }
}