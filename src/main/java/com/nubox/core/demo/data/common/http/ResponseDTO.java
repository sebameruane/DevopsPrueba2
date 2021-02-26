package com.nubox.core.demo.data.common.http;


import org.dozer.DozerBeanMapper;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import com.nubox.core.demo.data.common.bind.DTO;

public class ResponseDTO<T> extends HttpEntity<T> {

    private static final DozerBeanMapper modelMapper = new DozerBeanMapper();

    private HttpStatus status;

    ResponseDTO(T body, HttpStatus status) {
        super(body);
        this.status = status;
    }


    public static Builder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static Builder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static Builder status(HttpStatus status) {
        return new BodyBuilder(status);
    }

    public interface Builder {
        <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass);
    }

    private static class BodyBuilder  implements Builder{
        private HttpStatus status;

        public BodyBuilder(HttpStatus status) {
            this.status = status;
        }

        public <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass) {
            Assert.notNull(AnnotationUtils.getAnnotation(aClass, DTO.class),
                    "Type should contain DTO annotation");

            return new ResponseDTO<T>(modelMapper.map(entity, aClass), this.status);
        }
    }
}