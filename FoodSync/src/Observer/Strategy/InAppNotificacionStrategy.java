package Observer.Strategy;

import Observer.Notificacion;
import controlador.PantallaNotificacionesControlador;

public class InAppNotificacionStrategy implements NotificacionStrategy{
    private PantallaNotificacionesControlador notificacionesControlador;

    public InAppNotificacionStrategy() {
    }

    public void setNotificacionesControlador(PantallaNotificacionesControlador notificacionesControlador) {
        this.notificacionesControlador = notificacionesControlador;
    }
    
    @Override
    public void notificar(Notificacion notificacion) {
        notificacionesControlador.addNotification(notificacion);
    }
}
