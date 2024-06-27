package Observer;

import Observer.Strategy.EmailNotificationStrategy;
import Observer.Strategy.InAppNotificacionStrategy;
import Observer.Strategy.NotificacionStrategy;
import Observer.Strategy.SMSNotificacionStrategy;
import controlador.PantallaPrincipalControlador;
import java.time.LocalDate;
import java.util.List;
import modelo.Comida;

public class FechasDeVencimientoObserver implements Observer{
    private PantallaPrincipalControlador pantallaPrincipalControlador;
    
    
    EmailNotificationStrategy email = new EmailNotificationStrategy();
    SMSNotificacionStrategy sms = new SMSNotificacionStrategy();
    InAppNotificacionStrategy inApp = new InAppNotificacionStrategy();
	
    public FechasDeVencimientoObserver() {
    }
    

    @Override
    public void update(Notificacion notificacion) {
	if(notificacion == null){
            System.out.println("No new message");
	}else{
            email.notificar(notificacion);
            sms.notificar(notificacion);
            inApp.notificar(notificacion);
        }
    }

    public InAppNotificacionStrategy getInApp() {
        return inApp;
    }
}
