package com.pruebapractica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NombreService {

    // a) Lista de nombres
    public List<String> crearListaNombres() {
        return List.of(
                "Damian",
                "Ana",
                "Manuela",
                "Santiago",
                "Carlos",
                "Carlos",
                "Carlos"
        );
    }

    // b) Filtrar nombres que coincidan exactamente
    public List<String> filtrarPorNombre(List<String> nombres, String parametro) {
        return nombres.stream()
                .filter(nombre -> nombre.equals(parametro))
                .collect(Collectors.toList());
    }

    // c) Usar Optional para imprimir la lista filtrada
    public void imprimirSiExiste(List<String> listaFiltrada) {

        Optional.ofNullable(listaFiltrada)
                .filter(lista -> !lista.isEmpty())
                .ifPresent(lista ->
                        lista.forEach(nombre ->
                                System.out.println("Nombre encontrado: " + nombre)
                        )
                );
    }
}
