package com.pruebapractica.model;

public final class PersonaInmutable {

    private final String nombre;
    private final int edad;

    // Constructor
    public PersonaInmutable(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Solo getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void mostrar() {
        System.out.println("Persona Inmutable -> Nombre: " + nombre + ", Edad: " + edad);
    }
}
