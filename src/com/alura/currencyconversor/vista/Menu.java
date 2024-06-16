package com.alura.currencyconversor.vista;

import com.alura.currencyconversor.servicio.Conversion;

import java.util.Scanner;

public class Menu {
    private static void getMenu(){
        System.out.println("""
                *************************************************
                Sea bienvenid@ al Conversor de Moneda =]
                
                1) Dólar            =>>     Peso Argentino
                2) Peso Argentino   =>>     Dólar
                3) Dólar            =>>     Real Brasileño
                4) Real Brasileño   =>>     Dólar
                5) Dólar            =>>     Peso Colombiano
                6) Peso Colombiano  =>>     Dólar
                7) Salir""");
    }

    private static int selectorConversion(){
        Scanner opcion = new Scanner(System.in);
        System.out.println("""
                Elija una opción válida:
                *************************************************
                """);
        return opcion.nextInt();
    }

    private static long definaValor(){
        Scanner opcion = new Scanner(System.in);
        System.out.println("Ingrese el valor que deseas convertir:");
        return opcion.nextInt();
    }

    private static void gestionaConversion(int opcion, long valor){
        Conversion conversion = new Conversion();
        conversion.ResolverConversion(opcion, valor);
    }

    public static void disponibilidadApp(){
        int opcionCambioMoneda = 0;
        do {
            getMenu();
            opcionCambioMoneda = selectorConversion();
            if (opcionCambioMoneda != 7) {
                long valorCambiar = Menu.definaValor();
                gestionaConversion(opcionCambioMoneda, valorCambiar);
            }
        } while (opcionCambioMoneda != 7);
    }
}
