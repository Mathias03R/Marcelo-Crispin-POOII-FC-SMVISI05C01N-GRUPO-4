package Observer.Strategy;

import Observer.Notificacion;

public class SMSNotificacionStrategy implements NotificacionStrategy{
    @Override
    public void notificar(Notificacion notificacion) {
        // Simulación de envío de notificación por correo electrónico
        System.out.println("----------------------------------------------");
        System.out.println("Enviando a un celular por sms");
        System.out.println(notificacion.getTitle());
        System.out.println(notificacion.getDescription());
        System.out.println("----------------------------------------------");
    }
}
