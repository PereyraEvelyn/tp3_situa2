package org.example;

public class CuentaBancaria {
    private String cbu;
    private double saldo;

    public CuentaBancaria(String cbu, double saldoInicial) {
        this.cbu = cbu;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCbu() {
        return cbu;
    }

    public boolean debitar(double monto) {
    double comision = monto * 0.01; // comisión del 1%
    double montoTotalADebitar = monto + comision;

    if (montoTotalADebitar <= this.saldo) {
        this.saldo -= montoTotalADebitar;
        System.out.println("Debito de " + monto + " mas comision de " + comision + " realizado. Nuevo saldo: " + this.saldo);
        return true;
    } else {
        System.out.println("Saldo insuficiente para cubrir el monto.");
        return false;
    }
}
}