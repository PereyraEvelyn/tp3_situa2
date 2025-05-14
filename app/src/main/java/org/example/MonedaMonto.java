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

    // Método para convertir a otra moneda (simplificado, requiere TasaDeCambio)
    public MonedaMonto convertirA(Moneda monedaDestino, BigDecimal tasaDeCambio) {
        if (this.moneda.equals(monedaDestino)) {
            return this; // No se necesita conversión
        }
        // Aquí se usaría la tasa de cambio para realizar la conversión
        BigDecimal montoConvertido = this.monto.multiply(tasaDeCambio);
        return new MonedaMonto(montoConvertido, monedaDestino);
    }

    @Override
    public String toString() {
        return monto + " " + moneda.getCodigo();
    }
}