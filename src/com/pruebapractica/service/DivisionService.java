package com.pruebapractica.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

public class DivisionService {

    public static BinaryOperator<BigDecimal> dividir() {
        return (a, b) -> a.divide(b, 2, RoundingMode.HALF_UP);
    }
}
