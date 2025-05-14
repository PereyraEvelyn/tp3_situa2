package org.example;

import java.time.LocalDate;

public class Transaccion {
    private String idTransaccion;
    private Cliente cliente;
    private FormaDePago formaDePago;
    private MonedaMonto monto;
    private LocalDate fecha;

    public Transaccion(String idTransaccion, Cliente cliente, FormaDePago formaDePago, MonedaMonto monto) {
        this.idTransaccion = idTransaccion;
        this.cliente = cliente;
        this.formaDePago = formaDePago;
        this.monto = monto;
        this.fecha = LocalDate.now();
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public MonedaMonto getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean procesarTransaccion() {
        boolean pagoExitoso = this.formaDePago.procesarPago();
        if (pagoExitoso) {
            System.out.println("Transacción " + idTransaccion + " realizada con éxito el " + fecha + ".");
            return true;
        } else {
            System.out.println("Transacción " + idTransaccion + " fallida el " + fecha + ".");
            return false;
        }
    }
}