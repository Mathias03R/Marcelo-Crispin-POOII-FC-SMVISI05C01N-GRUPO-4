package Observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Comida;

public class FechasDeVencimientoSubject implements Subject{
        private List<Observer> observers;
	private Notificacion notificacion;
	private boolean changed;
	private final Object MUTEX= new Object();
        private List<Comida> comidas;
	
	public FechasDeVencimientoSubject(List<Comida> comidas){
		this.observers=new ArrayList<>();
                this.comidas = comidas;
	}
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		synchronized (MUTEX) {
			if (!changed)
                                return;
                        observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update(notificacion);
		}

	}
	
	public void newNotification(){
                LocalDate today = LocalDate.now();
                for (Comida comida : comidas) {
                    if (comida.getExpirationDate().isBefore(today.plusDays(10))) {
                        this.notificacion=new Notificacion("Producto pronto a vencer", comida.getName() + " (ID: "+ comida.getId() + ") Está pronta a vencer");
                        this.changed=true;
                        notifyObservers();
                    }
                }
        }
    
}
