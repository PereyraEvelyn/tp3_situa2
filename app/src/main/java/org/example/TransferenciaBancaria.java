package org.example;

public class TransferenciaBancaria implements FormaDePago {

    private CuentaBancaria cuentaOrigen;

    public TransferenciaBancaria(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    @Override
    public boolean pagar(Monto montoAPagar) {
        System.out.println("Intentando pagar " + montoAPagar.getValor() + " con Transferencia desde la cuenta " + cuentaOrigen.getCbu());

        boolean exito = cuentaOrigen.debitar(montoAPagar.getValor());

        if (exito) {
            System.out.println("Pago con Transferencia APROBADO.");
        } else {
            System.out.println("Error: Pago con Transferencia RECHAZADO.");
        }
        return exito;
    }
}