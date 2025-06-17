package org.example;

import java.util.Date;

public class Transaccion {
    private String idTransaccion;
    private Date fecha;
    private Cliente cliente;
    private Monto monto;
    private FormaDePago formaDePago; 
    private boolean exitosa;

    public Transaccion(String idTransaccion, Cliente cliente, Monto monto, FormaDePago formaDePago) {
        this.idTransaccion = idTransaccion;
        this.cliente = cliente;
        this.monto = monto;
        this.formaDePago = formaDePago;
        this.fecha = new Date(); // fecha actual al crear la transacción
        this.exitosa = false;    
    }

   
    public void procesarPago() {
        System.out.println("--- Iniciando Transaccion " + idTransaccion + " ---");
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto a pagar: " + monto);

        this.exitosa = formaDePago.pagar(this.monto);

        System.out.println("Estado de la Transaccion: " + (exitosa ? "APROBADA" : "RECHAZADA"));
        System.out.println("------------------------------------------\n");
    }

    public boolean fueExitosa() {
        return exitosa;
    }
}