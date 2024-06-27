package controlador;

import vista.CrearCuenta;
import vista.InicioSesion;
import modelo.User;

import javax.swing.JOptionPane;

import Repository.FileUserRepository;
import Repository.UserRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCuentaControlador {
    private CrearCuenta vista; // Referencia a la vista CrearCuenta
    private UserRepository userRepository; // Repositorio de usuarios

    public CrearCuentaControlador(CrearCuenta vista) {
        this.vista = vista;
        this.userRepository = new FileUserRepository(); // Inicialización del repositorio de usuarios
        initControlador(); // Configuración inicial del controlador
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón de Crear Cuenta
        vista.getCrearCuentaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos ingresados por el usuario
                String email = vista.getCorreoField().getText();
                String password = new String(vista.getContrasenaField().getPassword());
                String confirmPassword = new String(vista.getConfirmarContrasenaField().getPassword());

                System.out.println("Creating account with email: " + email + " and password: " + password);

                // Validación de campos
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else if (!validarFormatoEmail(email)) {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es válido");
                } else if (!validarCombinacionPassword(password)) {
                    JOptionPane.showMessageDialog(null,
                            "La contraseña debe contener una combinación de letras y números");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                } else {
                    // Verificar si el correo ya está registrado
                    boolean emailExists = userRepository.findAll().stream()
                            .anyMatch(user -> user.getEmail().equals(email));

                    if (emailExists) {
                        JOptionPane.showMessageDialog(null, "El correo ya está registrado");
                    } else {
                        // Crear nuevo usuario
                        Long newId = (long) (userRepository.findAll().size() + 1);
                        User newUser = new User(newId, email, password);
                        userRepository.save(newUser);
                        JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");

                        // Volver a la pantalla de inicio de sesión
                        new InicioSesionControlador(new InicioSesion());
                        vista.getFrame().dispose(); // Cerrar la ventana actual de CrearCuenta
                    }
                }
            }
        });

        // Configuración del ActionListener para el botón de Regresar
        vista.getRegresarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose(); // Cerrar la ventana actual de CrearCuenta

                // Mostrar nuevamente la pantalla de Inicio Sesion
                InicioSesion inicioSesion = new InicioSesion();
                new InicioSesionControlador(inicioSesion);
                inicioSesion.getFrame().setVisible(true); // Hacer visible la pantalla de Inicio Sesion
            }
        });
    }

    // Método para validar el formato del correo electrónico usando una expresión
    // regular
    private boolean validarFormatoEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    // Método para validar que la contraseña contenga al menos una letra y un número
    private boolean validarCombinacionPassword(String password) {
        boolean contieneLetras = false;
        boolean contieneNumeros = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                contieneLetras = true;
            } else if (Character.isDigit(c)) {
                contieneNumeros = true;
            }
            if (contieneLetras && contieneNumeros) {
                break;
            }
        }

        return contieneLetras && contieneNumeros;
    }

}
