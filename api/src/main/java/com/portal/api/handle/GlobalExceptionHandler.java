package com.portal.api.handle;

import com.portal.api.dto.Problem;
import com.portal.api.dto.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public Problem handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<Validations> errors = methodArgumentNotValidException
                .getFieldErrors()
                .stream()
                .map(error -> new Validations(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toList());
        return new Problem(HttpStatus.BAD_REQUEST.value(), "Request with invalid format", errors);
    }

}
