package com.alura.currencyconversor.modelo;

public class ApiRequest {
    private String origen;
    private String destino;
    private long valor;

    public ApiRequest(String origen, String destino, long valor) {
        this.origen = origen;
        this.destino = destino;
        this.valor = valor;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
}
