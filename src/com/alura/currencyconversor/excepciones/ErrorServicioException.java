package com.alura.currencyconversor.excepciones;

public class ErrorServicioException extends RuntimeException {

    private String mensaje;

    public ErrorServicioException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
