package org.example;

public class NotificadorSms implements Notificador {
     @Override
    public void enviar(String mensaje, Cliente cliente) {
        String telefonoDestino = cliente.getTelefono();
        System.out.println("Enviando SMS a [" + telefonoDestino + "]: \"" + mensaje + "\"");
    }
}