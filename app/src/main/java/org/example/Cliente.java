package org.example;

import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private String idCliente;
    private String nombre;
    private String email;
    private String telefono;
    private List<CuentaBancaria> cuentas;

    public Cliente(String idCliente, String nombre, String email, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        this.cuentas.add(cuenta);
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}