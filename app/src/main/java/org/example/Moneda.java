package org.example;

import java.util.Objects;

public class Moneda {
    private String codigo;
    private String nombre;
    private String simbolo;

    public Moneda(String codigo, String nombre, String simbolo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moneda moneda = (Moneda) o;
        return Objects.equals(codigo, moneda.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", simbolo='" + simbolo + '\'' +
                '}';
    }
}