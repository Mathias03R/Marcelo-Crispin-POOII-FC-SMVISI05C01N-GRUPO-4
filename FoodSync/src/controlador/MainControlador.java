package controlador;

import Observer.FechasDeVencimientoObserver;
import Observer.FechasDeVencimientoSubject;
import Repository.ComidaRepository;
import Repository.FileComidaRepository;
import java.time.LocalDate;
import java.util.List;
import modelo.Comida;
import vista.InicioSesion;

public class MainControlador {

    public static void main(String[] args) {
        new InicioSesionControlador(new InicioSesion());
        
        
    }
}
