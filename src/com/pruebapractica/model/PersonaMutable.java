package com.pruebapractica.model;

public class PersonaMutable {

    private String nombre;
    private int edad;

    // Constructor
    public PersonaMutable(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Setters (esto la hace mutable)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Persona Mutable -> Nombre: " + nombre + ", Edad: " + edad);
    }
}
