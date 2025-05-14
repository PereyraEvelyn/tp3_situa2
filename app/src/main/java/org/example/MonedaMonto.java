package org.example;
import java.math.BigDecimal;

public class MonedaMonto {
    private BigDecimal monto;
    private Moneda moneda;

    public MonedaMonto(BigDecimal monto, Moneda moneda) {
        this.monto = monto;
        this.moneda = moneda;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public MonedaMonto sumar(MonedaMonto otro){
        if(!validarMoneda(otro)){
            System.out.println("No se puede operar con monedas distintas" + this.moneda + "vs" + otro.moneda);
            return this;
        }
        return new MonedaMonto(this.monto.add(otro.monto), this.moneda);

    }

     public MonedaMonto restar(MonedaMonto otro){
        if(!validarMoneda(otro)){
            System.out.println("No se puede operar con monedas distintas" + this.moneda + "vs" + otro.moneda);
            return this;
        }
        return new MonedaMonto(this.monto.add(otro.monto), this.moneda);

    }

    public MonedaMonto convertirA(Moneda monedaDestino, BigDecimal tasaDeCambio) {
        if (this.moneda.equals(monedaDestino)) {
            return this; 
        }
        BigDecimal montoConvertido = this.monto.multiply(tasaDeCambio);
        return new MonedaMonto(montoConvertido, monedaDestino);
    }

    @Override
    public String toString() {
        return monto + " " + moneda.getCodigo();
    }
}