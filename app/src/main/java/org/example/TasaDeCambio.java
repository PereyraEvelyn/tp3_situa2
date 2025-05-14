package org.example;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TasaDeCambio {
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private BigDecimal tasa;
    private LocalDate fechaVigencia;

    public TasaDeCambio(Moneda monedaOrigen, Moneda monedaDestino, BigDecimal tasa, LocalDate fechaVigencia) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
        this.fechaVigencia = fechaVigencia;
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }
}