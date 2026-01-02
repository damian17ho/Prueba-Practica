package com.pruebapractica.model;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, int edad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
