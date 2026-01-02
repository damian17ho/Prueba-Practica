package com.pruebapractica.app;

import com.pruebapractica.model.PersonaMutable;
import com.pruebapractica.model.PersonaInmutable;
import com.pruebapractica.model.Libro;
import com.pruebapractica.model.Persona;
import com.pruebapractica.service.PotenciaService;
import com.pruebapractica.service.LibroService;
import com.pruebapractica.service.DivisionService;
import com.pruebapractica.service.ValidacionEdadService;
import com.pruebapractica.functional.ValidarEdadSAM;
import com.pruebapractica.service.FechaService;
import com.pruebapractica.service.Calculadora;
import com.pruebapractica.service.NombreService;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BinaryOperator;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n__________________________________________________");
        System.out.println("PUNTO #1");
        System.out.println("\nPRUEBA CLASE MUTABLE    ");
        PersonaMutable mutable = new PersonaMutable("Carlos", 20);
        mutable.mostrar();

        System.out.println("DATOS MODIFIADOS    ");
        mutable.setNombre("Carlos Gómez");
        mutable.setEdad(25);
        mutable.mostrar();

        System.out.println("\nPRUEBA CLASE INMUTABLE    ");
        PersonaInmutable inmutable = new PersonaInmutable("Ana", 30);
        inmutable.mostrar();

        System.out.println("INTENTANDO MODIFICAR DATOS     ");
        //inmutable.setNombre("Carlos Gómez");
        //inmutable.setEdad(25);
        mutable.mostrar();
        System.out.println("❌ No se puede modificar una clase inmutable");

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #2 y #3");
        System.out.println("\nPOTENCIA DE NUMERO  ");

        PotenciaService service = new PotenciaService();
        int base = 9;
        int exponente = 3;

        Function<Integer, Integer> calcularPotencia = service.potencia(exponente);
        int resultado = calcularPotencia.apply(base);

        Predicate<Integer> esPar = service.esPar();
        Function<Integer, String> mensajeResultado =
                service.mensajeParImpar(esPar);

        System.out.println("Numero a potenciar: " + base);
        System.out.println("Resultado de la potencia: " + resultado);
        System.out.println(mensajeResultado.apply(resultado));

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #4");
        System.out.println("\nRECOMENDACIÓN LIBROS");

        LibroService service1 = new LibroService();

        Supplier<List<Libro>> proveedorLibros = service1.crearListaLibros();
        List<Libro> libros = proveedorLibros.get();

        Consumer<List<Libro>> consumidorLibros = service1.procesarLibros();
        consumidorLibros.accept(libros);

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #5");
        System.out.println("\nBINARYOPERATOR");

        BinaryOperator<BigDecimal> division = DivisionService.dividir();
        BigDecimal num1 = new BigDecimal("20");
        BigDecimal num2 = new BigDecimal("6");

        BigDecimal resultadoBinary = division.apply(num1, num2);
        System.out.println("Resultado de la división: " + resultadoBinary);

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #6");
        System.out.println("\nSAM + BIFUNCTION (VALIDAR EDAD)");

        Persona persona = new Persona(
                "Damian",
                19,
                LocalDate.of(2007, 1, 3)
        );

        ValidacionEdadService validacionService = new ValidacionEdadService();

        BiFunction<LocalDate, Integer, Boolean> validarEdad =
                validacionService.validarEdad();

        ValidarEdadSAM validar = (nombre, edad, fechaNacimiento) -> {

            boolean coincide = validarEdad.apply(fechaNacimiento, edad);

            return "La fecha de nacimiento de " + nombre +
                    (coincide ? " corresponde " : " no corresponde ") +
                    "a la edad ingresada";
        };

        String mensaje = validar.validar(
                persona.getNombre(),
                persona.getEdad(),
                persona.getFechaNacimiento()
        );

        System.out.println(mensaje);

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #7");
        System.out.println("\nLISTA DE FECHAS");

        List<LocalDate> fechas = List.of(
                LocalDate.of(2024, 5, 10),
                LocalDate.of(2023, 12, 25),
                LocalDate.of(2022, 1, 1)
        );

        // Operador de referencia :: significa “usa este metodo
        //                    Clase::metodo
        fechas.forEach(FechaService::mostrarFecha);



        System.out.println("__________________________________________________");
        System.out.println("PUNTO #8");
        System.out.println("\nCALCULADORA ");

        Calculadora calc = new Calculadora();

        calc.sumar(10)
                .restar(3)
                .multiplicar(2);

        System.out.println("Resultado final: " + calc.getResultado());

        System.out.println("__________________________________________________");
        System.out.println("PUNTO #9");
        System.out.println("\nLista de nombres ");

        NombreService service2 = new NombreService();

        // Crear lista
        List<String> nombres = service2.crearListaNombres();
        // Filtrar lista
        List<String> filtrados = service2.filtrarPorNombre(nombres, "Carlos");
        // Imprimir usando Optional
        service2.imprimirSiExiste(filtrados);

    }
}
