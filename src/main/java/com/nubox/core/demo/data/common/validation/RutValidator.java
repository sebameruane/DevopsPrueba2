package com.nubox.core.demo.data.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class RutValidator implements ConstraintValidator<Rut, String> {

    @Override
    public void initialize(Rut constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validaRut(value);
    }

    private boolean validaRut(String rut) {
        if (rut == null || rut.isEmpty() || rut.isBlank()) {
            return false;
        }
        String dv = rut.substring(rut.length() - 1, rut.length()).toUpperCase();
        rut = rut.replaceAll("\\-", "");
        rut = rut.replaceAll("\\.", "");
        if (rut.length() <= 0) {
            return false;
        }
        rut = rut.substring(0, rut.length() - 1);
        int cantidad = rut.length();
        int factor = 2;
        int suma = 0;
        String verificador = "";
        for (int i = cantidad; i > 0; i--) {
            if (factor > 7) {
                factor = 2;
            }
            try {
                suma += ((Integer.parseInt(rut.substring((i - 1), i))) * factor);
                factor++;
            } catch (NumberFormatException exception) {
                return false;
            }
        }
        verificador = String.valueOf(11 - (suma % 11));
        if (verificador.equals("10")) {
            verificador = "K";
        } else {
            if (verificador.equals("11")) {
                verificador = "0";
            }
        }
        return verificador.equals(dv) ? true : false;
    }
}
