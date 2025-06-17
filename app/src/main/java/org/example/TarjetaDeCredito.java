package org.example;

import java.util.Date;

public class TarjetaDeCredito implements FormaDePago {

    private String numero;
    private Date fechaVencimiento;
    private Monto limiteCredito;

    public TarjetaDeCredito(String numero, Date fechaVencimiento, Monto limiteCredito) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.limiteCredito = limiteCredito;
    }
     public String getNumero() {
        return numero;
    }

    public Monto getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public boolean pagar(Monto montoAPagar) {
        System.out.println("Intentando pagar " + montoAPagar.getValor() + " con Tarjeta de Credito...");

        if (new Date().after(this.fechaVencimiento)) {
            System.out.println("Error: La tarjeta de credito esta vencida.");
            return false;
        }

        if (montoAPagar.getValor() <= this.limiteCredito.getValor()) {
            System.out.println("Pago con Tarjeta de Credito APROBADO.");
            // En un caso real, aquí se debitaría el monto del límite.
            return true;
        } else {
            System.out.println("Error: El monto excede el limite de credito disponible.");
            return false;
        }
    }
}
