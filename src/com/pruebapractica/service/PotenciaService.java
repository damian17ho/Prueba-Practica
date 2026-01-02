package com.pruebapractica.service;

import java.util.function.Function;
import java.util.function.Predicate;

public class PotenciaService {

    // Function: calcula la potencia
    public Function<Integer, Integer> potencia(int exponente) {
        return base -> {
            int resultado = 1;
            for (int i = 1; i <= exponente; i++) {
                resultado *= base;
            }
            return resultado;
        };
    }

    // Predicate: valida si un número es par
    public Predicate<Integer> esPar() {
        return numero -> numero % 2 == 0;
    }

    // Function: genera el mensaje según el Predicate
    public Function<Integer, String> mensajeParImpar(Predicate<Integer> predicado) {
        return numero -> predicado.test(numero)
                ? "✅ El resultado es PAR"
                : "❌ El resultado es IMPAR";
    }
}
