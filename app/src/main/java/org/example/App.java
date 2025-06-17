package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
   
        Moneda pesosARS = new Moneda("ARS", "Peso Argentino");
        Cliente cliente = new Cliente("C001", "Evelyn Pereyra");
        // Cuenta con $20,000 de saldo
        CuentaBancaria cuentaCliente = new CuentaBancaria("0170456000001234567890", 20000.0);
        cliente.agregarCuenta(cuentaCliente);

        Monto limiteTarjeta = new Monto(50000.0, pesosARS);
        Date fechaVencimiento = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(365 * 2)); 
        
       
        FormaDePago transferencia = new TransferenciaBancaria(cuentaCliente);
        Efectivo efectivo = new Efectivo(); 


        System.out.println("Datos del Cliente:");
        System.out.println("  - ID: " + cliente.getIdCliente());
        System.out.println("  - Nombre: " + cliente.getNombre());
        System.out.println("  - Cuenta Bancaria CBU: " + cuentaCliente.getCbu());
        System.out.println("    Saldo actual: $" + String.format("%.2f", cuentaCliente.getSaldo()));

        TarjetaDeCredito tarjetaConcreta = new TarjetaDeCredito("1234-5678-9012-3456", fechaVencimiento, limiteTarjeta);
         FormaDePago tarjeta = tarjetaConcreta; 
        // Mostrar datos de la tarjeta de crédito
        System.out.println("  - Tarjeta de Credito Nro: " + tarjetaConcreta.getNumero());
        System.out.println("    Limite de credito: " + tarjetaConcreta.getLimiteCredito());
        
        System.out.println("\n=======================================================\n");


        System.out.println("PRUEBAS DE TARJETA DE CREDITO \n");
        
        //  Pago exitoso con tarjeta
        Monto compraConTarjetaExitosa = new Monto(15000.0, pesosARS);
        Transaccion transaccion1 = new Transaccion("T01", cliente, compraConTarjetaExitosa, tarjeta);
        transaccion1.procesarPago();

        // Pago fallido 
        Monto compraConTarjetaFallida = new Monto(60000.0, pesosARS);
        Transaccion transaccion2 = new Transaccion("T02", cliente, compraConTarjetaFallida, tarjeta);
        transaccion2.procesarPago();

        System.out.println("PRUEBAS DE TRANSFERENCIA\n");

        // Pago exitoso con transferencia
        Monto compraConTransferenciaExitosa = new Monto(18000.0, pesosARS);
        Transaccion transaccion3 = new Transaccion("T03", cliente, compraConTransferenciaExitosa, transferencia);
        transaccion3.procesarPago(); // Saldo restante en cuenta: 20000 - 18000 = 2000


        // Pago fallido con transferencia
        Monto compraConTransferenciaFallida = new Monto(3000.0, pesosARS);
        Transaccion transaccion4 = new Transaccion("T04", cliente, compraConTransferenciaFallida, transferencia);
        transaccion4.procesarPago(); // solo hay 2000

       
        System.out.println("PRUEBAS EN EFECTIVO\n");

        //  Pago en efectivo con calculo de cambio
        Monto compraEnEfectivo1 = new Monto(950.50, pesosARS);
        Monto dineroEntregado1 = new Monto(1000.0, pesosARS);
        System.out.println("--- Transaccion en efectivo T05 ---");
        efectivo.pagar(compraEnEfectivo1, dineroEntregado1);
        System.out.println("----------------------------------\n");

    }
}
