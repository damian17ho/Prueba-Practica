package com.pruebapractica.functional;

import java.time.LocalDate;

@FunctionalInterface
public interface ValidarEdadSAM {

    String validar(String nombre, int edad, LocalDate fechaNacimiento);
}
