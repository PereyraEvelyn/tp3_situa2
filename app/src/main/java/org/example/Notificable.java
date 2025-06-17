package org.example;

public interface Notificable {
    void enviarNotificacion(String mensaje, Cliente cliente);
    void setNotificador(Notificador notificador);
}