package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InicioSesion {
    private JFrame frame;
    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton iniciarSesionButton;
    private JButton registroButton;

    public InicioSesion() {
        // Crear el frame
        frame = new JFrame("FoodSync");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta de título
        JLabel titulo = new JLabel("INICIAR SESIÓN");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setBounds(380, 120, 200, 25);
        panel.add(titulo);

        // Campo de correo electrónico
        correoField = new JTextField(20);
        correoField.setBounds(355, 160, 200, 25);
        panel.add(correoField);

        // Campo de contraseña
        contrasenaField = new JPasswordField(20);
        contrasenaField.setBounds(355, 200, 200, 25);
        panel.add(contrasenaField);

        // Botón de iniciar sesión
        iniciarSesionButton = new JButton("Iniciar Sesión");
        iniciarSesionButton.setBounds(355, 250, 200, 25);
        iniciarSesionButton.setBackground(new Color(154, 191, 155));
        panel.add(iniciarSesionButton);

        // Etiqueta y link de registro
        JLabel registroLabel = new JLabel("Si no tiene una cuenta");
        registroLabel.setBounds(340, 300, 150, 25);
        panel.add(registroLabel);

        registroButton = new JButton("regístrese aquí");
        registroButton.setBounds(480, 300, 120, 25);
        registroButton.setBackground(new Color(238, 238, 238, 255));
        panel.add(registroButton);

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

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public JButton getRegistroButton() {
        return registroButton;
    }
}
