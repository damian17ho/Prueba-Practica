package com.pruebapractica.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiFunction;

public class ValidacionEdadService {

    // BiFunction: fechaNacimiento + edadIngresada → boolean
    public BiFunction<LocalDate, Integer, Boolean> validarEdad() {
        return (fechaNacimiento, edadIngresada) -> {
            int edadReal = Period.between(fechaNacimiento, LocalDate.now()).getYears();
            return edadReal == edadIngresada;
        };
    }
}
