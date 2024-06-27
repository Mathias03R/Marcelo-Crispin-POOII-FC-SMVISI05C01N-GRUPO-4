package controlador;

import vista.CrearCuenta;
import vista.InicioSesion;
import vista.PantallaPrincipal;
import modelo.User;

import javax.swing.JOptionPane;

import Repository.FileUserRepository;
import Repository.UserRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class InicioSesionControlador {
    private InicioSesion vista; // Referencia a la vista InicioSesion
    private UserRepository userRepository; // Repositorio de usuarios

    public InicioSesionControlador(InicioSesion vista) {
        this.vista = vista;
        this.userRepository = new FileUserRepository(); // Inicialización del repositorio de usuarios
        initControlador(); // Configuración inicial del controlador
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón de Iniciar Sesión
        vista.getIniciarSesionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos ingresados por el usuario
                String email = vista.getCorreoField().getText();
                String password = new String(vista.getContrasenaField().getPassword());

                System.out.println("Intento de inicio de sesión con correo: " + email + " y contraseña: " + password);

                // Buscar el usuario en el repositorio
                Optional<User> userOpt = userRepository.findAll().stream()
                        .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                        .findFirst();
                
                System.out.println(userRepository.findAll().stream());

                // Verificar si el usuario existe y la contraseña coincide
                if (userOpt.isPresent()) {
                    System.out.println("Inicio de sesión exitoso para el usuario: " + userOpt.get());
                    vista.getFrame().setVisible(false); // Ocultar la ventana de InicioSesion
                    
                    new PantallaPrincipalControlador(new PantallaPrincipal()).getVista().getFrame().setVisible(true); // Mostrar
                                                                                                                      // la
                                                                                                                      // PantallaPrincipal
                } else {
                    System.out.println("Inicio de sesión fallido para correo: " + email);
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
                }
            }
        });

        // Configuración del ActionListener para el botón de Registro
        vista.getRegistroButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de CrearCuenta al hacer clic en Registro
                new CrearCuentaControlador(new CrearCuenta());
                vista.getFrame().dispose(); // Cerrar la ventana actual de InicioSesion
            }
        });
    }
}
