package com.alura.currencyconversor.servicio;

import com.alura.currencyconversor.modelo.ApiRequest;
import com.alura.currencyconversor.modelo.ApiResponse;

import java.text.NumberFormat;
import java.util.Locale;

public class Conversion {
    PeticionApi api = new PeticionApi();

    public void ResolverConversion(int opcion, long valor){
        ApiResponse response = api.apiResponse(defineRequest(opcion, valor));
        System.out.printf("El valor %s [%s] corresponde al valor final de =>>> %s [%s]%n%n",
                currencyFormater((double) valor),
                response.getBase_code(),
                currencyFormater(valor * response.getConversion_rate()),
                response.getTarget_code());
    }

    private ApiRequest defineRequest(int opcion, long valor){
        return switch (opcion) {
            case 1 -> new ApiRequest(
                    "USD",
                    "ARS",
                    valor
            );
            case 2 -> new ApiRequest(
                    "ARS",
                    "USD",
                    valor
            );
            case 3 -> new ApiRequest(
                    "USD",
                    "BRL",
                    valor
            );
            case 4 -> new ApiRequest(
                    "BRL",
                    "USD",
                    valor
            );
            case 5 -> new ApiRequest(
                    "USD",
                    "COP",
                    valor
            );
            case 6 -> new ApiRequest(
                    "COP",
                    "USD",
                    valor
            );
            default -> throw new IllegalStateException("Debe definir un valor para: " + opcion);
        };
    }

    private String currencyFormater(Double availableDbe) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(availableDbe);
    }
}
