package xyz.somedefinitions.ejile.controller;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.somedefinitions.ejile.entity.RequestResult;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {
    @ExceptionHandler(value = Exception.class)
    public RequestResult<Void> exceptionHandler(HttpServletRequest request,Exception e){
        RequestResult<Void> result = null;
        if(e instanceof MethodArgumentNotValidException){
            result =new RequestResult<>(false,null,
                    ((MethodArgumentNotValidException)e).getBindingResult()
                            .getFieldError().getDefaultMessage());
        }
        return result;
    }
}
