package com.nubox.core.demo.data.common.exception;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class FailureResponse {
    private Integer status;
    private Long timeStamp;
    private String message;
    private String[] errors;
    private String[] otro;



    
}
