package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
         // Crear monedas
        Moneda usd = new Moneda("USD", "Dólar Estadounidense", "$");
        Moneda eur = new Moneda("EUR", "Euro", "€");
        Moneda ars = new Moneda("ARS", "Peso Argentino", "$");

        // Crear tasas de cambio (ejemplo)
        LocalDate hoy = LocalDate.now();
        TasaDeCambio usdToEur = new TasaDeCambio(usd, eur, new BigDecimal("0.85"), hoy);
        TasaDeCambio usdToArs = new TasaDeCambio(usd, ars, new BigDecimal("290.50"), hoy);

        // Crear clientes
        Cliente cliente1 = new Cliente("C001", "Juan Pérez");
        Cliente cliente2 = new Cliente("C002", "María García");

        //Crear Cuentas Bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("123456", cliente1, new MonedaMonto(new BigDecimal("10000"), usd));
        CuentaBancaria cuenta2 = new CuentaBancaria("789012", cliente2, new MonedaMonto(new BigDecimal("500000"), ars));
        cliente1.agregarCuentaBancaria(cuenta1);
        cliente2.agregarCuentaBancaria(cuenta2);

        // Crear montos
        MonedaMonto montoUsd1 = new MonedaMonto(new BigDecimal("100"), usd);
        MonedaMonto montoEur1 = montoUsd1.convertirA(eur, usdToEur.getTasa()); // Ejemplo de conversión
        MonedaMonto montoArs1 = new MonedaMonto(new BigDecimal("50000"), ars);
        MonedaMonto montoUsd2 = new MonedaMonto(new BigDecimal("200"), usd);

        // Crear formas de pago
        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito(montoUsd1, "1234-5678-9012-3456", new MonedaMonto(new BigDecimal("500"), usd));
        Efectivo efectivo1 = new Efectivo(montoArs1, new MonedaMonto(new BigDecimal("55000"), ars));
        TransferenciaBancaria transferencia1 = new TransferenciaBancaria(montoUsd2, "123456", "987654", cuenta1);

        // Crear transacciones
        Transaccion transaccion1 = new Transaccion("T001", cliente1, tarjeta1, montoUsd1);
        Transaccion transaccion2 = new Transaccion("T002", cliente2, efectivo1, montoArs1);
        Transaccion transaccion3 = new Transaccion("T003", cliente1, transferencia1, montoUsd2);

        // Procesar transacciones
        transaccion1.procesarTransaccion();
        transaccion2.procesarTransaccion();
        transaccion3.procesarTransaccion();

        System.out.println("Saldo de la cuenta de Juan Pérez después de la transacción: " + cuenta1.getSaldo());

    }
}
