package org.example;
public abstract class FormaDePago {
    private MonedaMonto monto;

    public FormaDePago(MonedaMonto monto) {
        this.monto = monto;
    }

    public MonedaMonto getMonto() {
        return monto;
    }

     public abstract boolean procesarPago();
}