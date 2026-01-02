package com.pruebapractica.service;

import com.pruebapractica.model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LibroService {

    // b) Supplier que crea una lista de libros
    public Supplier<List<Libro>> crearListaLibros() {
        return () -> {
            List<Libro> libros = new ArrayList<>();
            libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 9));
            libros.add(new Libro("El principito", "Antoine de Saint-Exupéry", 2));
            libros.add(new Libro("Mi psicologa me dijo", "Katherine Hoyer y Yulibeth R.G.", 10));
            libros.add(new Libro("Harry Potter", "J.K Rowling", 10));
            return libros;
        };
    }

    //Consumer que procesa la lista
    public Consumer<List<Libro>> procesarLibros() {

        // Predicate: libro recomendado si puntaje >= 7
        Predicate<Libro> esRecomendado =
                libro -> libro.getPuntaje() >= 7;

        // UnaryOperator: genera el mensaje
        UnaryOperator<Libro> mostrarMensaje = libro -> {
            System.out.println("📘 El libro \"" + libro.getNombre() + "\" es recomendado 😍");
            return libro;
        };

        return listaLibros -> listaLibros.stream()
                .filter(esRecomendado)
                .forEach(mostrarMensaje::apply);
    }
}
