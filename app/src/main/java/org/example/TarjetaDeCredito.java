package org.example;
public class TarjetaDeCredito extends FormaDePago {
    private String numeroTarjeta;
    private MonedaMonto limiteCredito;

    public TarjetaDeCredito(MonedaMonto monto, String numeroTarjeta, MonedaMonto limiteCredito) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
        this.limiteCredito = limiteCredito;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public MonedaMonto getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public boolean procesarPago() {
        // Lógica para validar el límite de crédito, promociones, etc.
        if (limiteCredito.getMonto().compareTo(getMonto().getMonto()) >= 0) {
            System.out.println("Pago con Tarjeta de Crédito Aprobado: " + getMonto());
            return true;
        } else {
            System.out.println("Pago con Tarjeta de Crédito Rechazado: Límite de crédito excedido.");
            return false;
        }
    }
}
