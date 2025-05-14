package org.example;
import java.math.BigDecimal;

public class Efectivo extends FormaDePago {
    private MonedaMonto montoEntregado;

    public Efectivo(MonedaMonto monto, MonedaMonto montoEntregado) {
        super(monto);
        this.montoEntregado = montoEntregado;
    }

    public MonedaMonto getMontoEntregado() {
        return montoEntregado;
    }

    @Override
    public boolean procesarPago() {
        // Lógica para calcular el cambio y registrar los billetes
        if (montoEntregado.getMonto().compareTo(getMonto().getMonto()) >= 0) {
            BigDecimal cambio = montoEntregado.getMonto().subtract(getMonto().getMonto());
            System.out.println("Pago con Efectivo Aprobado: " + getMonto() + ", Cambio: " + cambio + " " + getMonto().getMoneda().getCodigo());
            // Aquí iría la lógica para registrar los billetes entregados
            return true;
        } else {
            System.out.println("Pago con Efectivo Rechazado: Monto insuficiente.");
            return false;
        }
    }
}
