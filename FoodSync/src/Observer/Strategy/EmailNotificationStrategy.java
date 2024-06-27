
package Observer.Strategy;

import Observer.Notificacion;

public class EmailNotificationStrategy implements NotificacionStrategy{
    @Override
    public void notificar(Notificacion notificacion) {
        // Simulación de envío de notificación por correo electrónico
        System.out.println("----------------------------------------------");
        System.out.println("Enviando al correo electronico:");
        System.out.println(notificacion.getTitle());
        System.out.println(notificacion.getDescription());
        System.out.println("----------------------------------------------");
    }
}
