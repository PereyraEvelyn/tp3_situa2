package org.example;

public class NotificadorWhatsapp implements Notificador {
     @Override
    public void enviar(String mensaje, Cliente cliente) {
        String telefonoDestino = cliente.getTelefono();
        System.out.println("Enviando WhatsApp a [" + telefonoDestino + "]: \"" + mensaje + "\"");
    }
}