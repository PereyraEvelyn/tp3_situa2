package org.example;
import java.math.BigDecimal;

public class TransferenciaBancaria extends FormaDePago {
    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private CuentaBancaria cuentaOrigen;  // Referencia a la cuenta

    public TransferenciaBancaria(MonedaMonto monto, String numeroCuentaOrigen, String numeroCuentaDestino, CuentaBancaria cuentaOrigen) {
        super(monto);
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

     public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    @Override
    public boolean procesarPago() {
        // Lógica para verificar el saldo y las comisiones
        if (cuentaOrigen != null && cuentaOrigen.getSaldo().getMonto().compareTo(getMonto().getMonto()) >= 0) {
             //Simulando Comision
            BigDecimal comision = getMonto().getMonto().multiply(new BigDecimal("0.01"));
            cuentaOrigen.debitar(new MonedaMonto(getMonto().getMonto().add(comision), getMonto().getMoneda()));
            System.out.println("Pago por Transferencia Bancaria Aprobado: " + getMonto() + " ,Comision: " + comision + " " + getMonto().getMoneda().getCodigo());

            return true;
        } else if (cuentaOrigen == null) {
             System.out.println("Pago por Transferencia Bancaria Rechazado: Cuenta de origen no encontrada.");
            return false;
        }
        else {
            System.out.println("Pago por Transferencia Bancaria Rechazado: Saldo insuficiente.");
            return false;
        }
    }
}
