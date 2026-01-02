package com.pruebapractica.service;

import java.time.LocalDate;

public class FechaService {

    public static void mostrarFecha(LocalDate fecha) {
        System.out.println(
                "La fecha es " +
                        fecha.getDayOfMonth() + " de " +
                        fecha.getMonthValue() + " del " +
                        fecha.getYear()
        );
    }
}
