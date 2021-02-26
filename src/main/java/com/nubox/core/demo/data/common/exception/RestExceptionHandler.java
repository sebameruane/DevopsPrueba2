package com.nubox.core.demo.data.common.exception;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        String message = "Error Interno";
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, ApiError.Type.TECHNICAL),HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "JSON mal formado";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), message, ApiError.Type.BUSINESS),HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Error de validaciones";
        List<FieldError> errorsFields = ex.getBindingResult().getFieldErrors();
        List<ApiSubError> errors = new ArrayList<>();
        for(FieldError e: errorsFields){
            ApiSubError err = new ApiValidationError(e.getObjectName(),e.getField(),e.getRejectedValue(),e.getDefaultMessage());
            errors.add(err);
            }


        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), message, ApiError.Type.BUSINESS, errors),HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder message=new StringBuilder("Content type ");
        message.append(ex.getContentType());
        message.append(" no permitido");
        return buildResponseEntity(new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), message.toString(), ApiError.Type.BUSINESS),HttpStatus.UNSUPPORTED_MEDIA_TYPE);

    }



    private ResponseEntity<Object> buildResponseEntity(ApiError apiError, HttpStatus httpStatus) {
        return new ResponseEntity<>(apiError, httpStatus);
    }

    //other exception handlers below

}
