package com.pruebapractica.service;

public class Calculadora {

    private int acumulado = 0;

    public Calculadora sumar(int valor) {
        acumulado += valor;
        System.out.println("Sumando " + valor + " → Acumulado: " + acumulado);
        return this;
    }

    public Calculadora restar(int valor) {
        acumulado -= valor;
        System.out.println("Restando " + valor + " → Acumulado: " + acumulado);
        return this;
    }

    public Calculadora multiplicar(int valor) {
        acumulado *= valor;
        System.out.println("Multiplicando por " + valor + " → Acumulado: " + acumulado);
        return this;
    }

    public int getResultado() {
        return acumulado;
    }
}
