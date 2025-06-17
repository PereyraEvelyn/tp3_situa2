# TP3_situacion2_289

## Actualizacion del Sistema

Para atender los nuevos requisitos, fue necesario introducir nuevos conceptos y responsabilidades. 

1. Nuevas Interfaces: Notificador y Notificable
El requisito principal era agregar notificaciones (Email, WhatsApp, SMS) que solo se aplicarían a ciertas formas de pago.  Para resolver esto se decidió crear dos nuevas interfaces.

## Notificador (Nueva Interface):
La interfaz Notificador establece un "contrato" común con el método enviar(String mensaje, Cliente cliente). Cualquier clase que represente un método de envío (como NotificadorEmail o NotificadorWhatsapp) debe implementar esta interfaz. Esto permite al sistema poder trabajar con cualquier Notificador sin conocer los detalles de su implementación, haciendo que agregar nuevos métodos de notificación en el futuro sea simple. 


## Notificable (Nueva Interface):

Se Necesitába una forma de dar la capacidad de notificar solo a TarjetaDeCredito y TransferenciaBancaria.  Crear una interfaz Notificable nos permite marcar a estas clases. La clase Efectivo no la implementa y, por lo tanto, no tiene esta capacidad. 

## Nuevas Clases: NotificadorEmail, NotificadorWhatsapp
Son las implementaciones concretas de la interfaz Notificador. Cada una tiene la lógica específica para un canal de comunicación.  NotificadorEmail sabe cómo usar el email del cliente y NotificadorWhatsapp su teléfono. 

## Modificaciones a Clases Existentes
### Cliente (Clase Modificada):
La información de contacto (email, teléfono) es un atributo de un cliente, no de una forma de pago. Se agregaron estos campos a la clase Cliente.

### TarjetaDeCredito y TransferenciaBancaria (Clases Modificadas):
Estas clases ahora implementan la nueva interfaz Notificable. tienen la responsabilidad de gestionar un objeto Notificador y delegarle la acción de enviar la notificación. contienen la lógica de iniciar el envío. 

###  Transaccion (Clase Modificada):
ahora pregunta "¿tienes la capacidad de notificar?" (instanceof Notificable). 