package org.example;

public class Efectivo implements FormaDePago {

   @Override
    public boolean pagar(Monto montoAPagar) {
        System.out.println("Procesando pago en EFECTIVO por " + montoAPagar + " (monto exacto)...");
        System.out.println("Pago en Efectivo ACEPTADO.");
        return true;
    }

     public boolean pagar(Monto montoAPagar, Monto montoEntregado) {
        System.out.println("Procesando pago en EFECTIVO...");
        System.out.println("Monto a pagar: " + montoAPagar);
        System.out.println("Monto entregado: " + montoEntregado);


        if (!montoAPagar.getMoneda().equals(montoEntregado.getMoneda())) {
            System.out.println("Error: Las monedas del pago y del monto entregado no coinciden.");
            return false;
        }

        if (montoEntregado.getValor() < montoAPagar.getValor()) {
            System.out.println("Error: El monto entregado es insuficiente.");
            return false;
        }

        // Calcula el cambio
        double valorCambio = montoEntregado.getValor() - montoAPagar.getValor();
        Monto cambio = new Monto(valorCambio, montoAPagar.getMoneda());

        System.out.println("Pago ACEPTADO. Su cambio es: " + cambio);
        return true;
    }
}