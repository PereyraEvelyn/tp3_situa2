package org.example;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<CuentaBancaria> cuentasBancarias;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.cuentasBancarias = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void agregarCuentaBancaria(CuentaBancaria cuenta) {
        this.cuentasBancarias.add(cuenta);
    }
}