package org.example;

public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String mensaje, Cliente cliente) {
        String emailDestino = cliente.getEmail();
        System.out.println("Enviando Email a [" + emailDestino + "]: \"" + mensaje + "\"");
    }
}