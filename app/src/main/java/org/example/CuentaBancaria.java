package org.example;

public class CuentaBancaria {
    private String numeroCuenta;
    private Cliente cliente;
    private MonedaMonto saldo;

    public CuentaBancaria(String numeroCuenta, Cliente cliente, MonedaMonto saldo) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public MonedaMonto getSaldo() {
        return saldo;
    }

    public void debitar(MonedaMonto monto) {
        if (this.saldo.getMoneda().equals(monto.getMoneda()) && this.saldo.getMonto().compareTo(monto.getMonto()) >= 0) {
            this.saldo = new MonedaMonto(this.saldo.getMonto().subtract(monto.getMonto()), this.saldo.getMoneda());
        } else {
            throw new IllegalArgumentException("Saldo insuficiente o moneda incorrecta");
        }
    }

     public void acreditar(MonedaMonto monto) {
        if (this.saldo.getMoneda().equals(monto.getMoneda())) {
            this.saldo = new MonedaMonto(this.saldo.getMonto().add(monto.getMonto()), this.saldo.getMoneda());
        } else {
            throw new IllegalArgumentException("Moneda incorrecta");
        }
    }
}
