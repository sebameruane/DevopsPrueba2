package com.nubox.core.demo.data.common.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Realiza validación de Modulo 11 Rut Chileno, no nulo, no blanco ni vacío; recibe como paramentro el rut completo a validar incluyendo digito verificador.
 * Ej: 46666666-1
 * */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = RutValidator.class)
@Documented
public @interface Rut {

    String message() default "{com.nubox.validation.Rut.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}