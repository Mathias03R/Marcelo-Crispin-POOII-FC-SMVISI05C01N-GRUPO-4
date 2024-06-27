package controlador;

import Observer.Notificacion;
import java.util.ArrayList;
import java.util.List;
import vista.PantallaNotificaciones;

public class PantallaNotificacionesControlador {
    private List<Notificacion> notificaciones;
    private PantallaNotificaciones pantallaNotificaciones = new PantallaNotificaciones();

    public PantallaNotificacionesControlador() {
        this.notificaciones = new ArrayList<>();
        pantallaNotificaciones.getFrame().setVisible(true);
    }

    public void addNotification(Notificacion notificacion) {
        notificaciones.add(notificacion);
        pantallaNotificaciones.showNotifications(notificaciones);
    }
}
