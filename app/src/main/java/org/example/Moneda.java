package org.example;

import java.util.Objects;

public class Moneda {
    private String codigoISO; 
    private String nombre;    

    public Moneda(String codigoISO, String nombre) {
        this.codigoISO = codigoISO;
        this.nombre = nombre;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return codigoISO; 
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moneda moneda = (Moneda) o;
        return Objects.equals(codigoISO, moneda.codigoISO);
    }

}