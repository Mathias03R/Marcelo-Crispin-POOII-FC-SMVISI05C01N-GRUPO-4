package controlador;

import Observer.FechasDeVencimientoObserver;
import Observer.FechasDeVencimientoSubject;
import Repository.ComidaRepository;
import Repository.FileComidaRepository;
import vista.AgregarProductos;
import vista.BuscarProducto;
import vista.EliminarProductos;
import vista.PantallaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Comida;
import vista.PantallaNotificaciones;

public class PantallaPrincipalControlador {
    private PantallaPrincipal vista; // Referencia a la vista PantallaPrincipal
    private PantallaNotificacionesControlador notificacionesControlador;

    public PantallaPrincipalControlador(PantallaPrincipal vista) {
        this.vista = vista;
        initControlador(); // Inicializar el controlador al crear una instancia
    }

    public PantallaPrincipal getVista() {
        return vista;
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón Agregar
        vista.getAgregarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana PantallaPrincipal
                vista.getFrame().dispose();

                // Mostrar la ventana AgregarProductos
                AgregarProductos agregarProductos = new AgregarProductos();
                new AgregarProductosControlador(agregarProductos); // Crear y vincular controlador de AgregarProductos
                agregarProductos.getFrame().setVisible(true); // Hacer visible la ventana AgregarProductos
            }
        });

        // Configuración del ActionListener para el botón Eliminar
        vista.getEliminarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana PantallaPrincipal
                vista.getFrame().dispose();

                // Mostrar la ventana EliminarProductos
                EliminarProductos eliminarProductos = new EliminarProductos();
                new EliminarProductosControlador(eliminarProductos); // Crear y vincular controlador de
                                                                     // EliminarProductos
                eliminarProductos.getFrame().setVisible(true); // Hacer visible la ventana EliminarProductos
            }
        });

        // Configuración del ActionListener para el botón Buscar
        vista.getBuscarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana PantallaPrincipal
                vista.getFrame().dispose();

                // Mostrar la ventana BuscarProducto
                BuscarProducto buscarProducto = new BuscarProducto();
                new BuscarProductoControlador(buscarProducto); // Crear y vincular controlador de BuscarProducto
                buscarProducto.getFrame().setVisible(true); // Hacer visible la ventana BuscarProducto
            }
        });
        
        vista.getNotificacionButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Abrir la pestaña de Notificaciones
                notificacionesControlador = new PantallaNotificacionesControlador();
                ComidaRepository comidaRepository = new FileComidaRepository();
        
                List<Comida> comidas = comidaRepository.findAll();

                FechasDeVencimientoObserver observerFechasvencidas = new FechasDeVencimientoObserver();
                FechasDeVencimientoSubject fechasVencidas = new FechasDeVencimientoSubject(comidas);
                
                fechasVencidas.register(observerFechasvencidas);
                
                observerFechasvencidas.getInApp().setNotificacionesControlador(notificacionesControlador);

                fechasVencidas.newNotification();
            }
        });
        
        
    }

    public PantallaNotificacionesControlador getNotificacionesControlador() {
        return notificacionesControlador;
    }
}
