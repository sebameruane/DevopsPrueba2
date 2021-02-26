package com.nubox.core.demo.data.common.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;


public class ApiError {

    private Integer status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private  Type type;
    private List<ApiSubError> errors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(Integer status) {
        this();
        this.status = status;
    }

    ApiError(Integer status, Type type) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.type = type;
    }

    ApiError(Integer status, String message, Type type) {
        this();
        this.status = status;
        this.message = message;
        this.type = type;
    }

    ApiError(Integer status, String message, Type type, List<ApiSubError> errors) {
        this();
        this.status = status;
        this.message = message;
        this.type = type;
        this.errors = errors;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setErrors(List<ApiSubError> subErrors) {
        this.errors = errors;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }


    public List<ApiSubError> getErrors() {
        return errors;
    }

    public Type getType() {
        return type;
    }

    public static enum Type {
        BUSINESS, TECHNICAL, UNKNOWN;
    }
}

