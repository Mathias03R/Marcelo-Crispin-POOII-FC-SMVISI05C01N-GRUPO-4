package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class CrearCuenta {
    private JFrame frame;
    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JPasswordField confirmarContrasenaField;
    private JButton crearCuentaButton;
    private JButton regresarButton;

    public CrearCuenta() {
        // Crear el frame
        frame = new JFrame("FoodSync");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta de título
        JLabel titulo = new JLabel("Crear tu Cuenta ;)");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(380, 120, 200, 25);
        panel.add(titulo);

        // Campo de correo electrónico
        correoField = new JTextField();
        correoField.setBounds(360, 160, 200, 25);
        panel.add(correoField);

        // Campo de contraseña
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(360, 200, 200, 25);
        panel.add(contrasenaField);

        // Campo de confirmación de contraseña
        confirmarContrasenaField = new JPasswordField();
        confirmarContrasenaField.setBounds(360, 230, 200, 25);
        panel.add(confirmarContrasenaField);

        // Botón de crear cuenta
        crearCuentaButton = new JButton("Crear cuenta");
        crearCuentaButton.setBounds(400, 300, 120, 25);
        crearCuentaButton.setBackground(new Color(154, 191, 155));
        panel.add(crearCuentaButton);

        // Botón de regresar a la PantallaPrincipal
        regresarButton = new JButton("↤");
        regresarButton.setBounds(810, 4, 50, 30);
        regresarButton.setBackground(new Color(217, 217, 217));
        panel.add(regresarButton);

        // Agregar panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    public JPasswordField getConfirmarContrasenaField() {
        return confirmarContrasenaField;
    }

    public JButton getCrearCuentaButton() {
        return crearCuentaButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }
}
