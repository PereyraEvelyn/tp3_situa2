package org.example;

public class Monto {
    private double valor;
    private Moneda moneda;

    public Monto(double valor, Moneda moneda) {
        this.valor = valor;
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public Moneda getMoneda() {
        return moneda;
    }


    @Override
    public String toString() {
        return String.format("%.2f %s", valor, moneda.toString());
    }
}