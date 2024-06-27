package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaPrincipal {
    private JFrame frame;
    private JButton notificacionButton;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton buscarButton;

    public PantallaPrincipal() {
        // Crear el frame
        frame = new JFrame("FoodSync");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta de título
        JLabel titulo = new JLabel("Administrar Alimentos");
        titulo.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo.setBounds(20, 20, 200, 25);
        panel.add(titulo);

        // Botón de notificación
        notificacionButton = new JButton("🔔");
        notificacionButton.setBounds(820, 20, 50, 35);
        notificacionButton.setBackground(new Color(217, 217, 217));
        panel.add(notificacionButton);

        // Botón de agregar alimentos
        agregarButton = new JButton("Agregar Alimentos");
        agregarButton.setBackground(new Color(158, 200, 106));// Verde claro
        agregarButton.setBounds(100, 150, 200, 150);
        panel.add(agregarButton);

        // Botón de eliminar alimentos
        eliminarButton = new JButton("Eliminar Alimentos");
        eliminarButton.setBackground(new Color(226, 99, 99)); // Rojo claro
        eliminarButton.setBounds(350, 150, 200, 150);
        panel.add(eliminarButton);

        // Botón de buscar alimentos
        buscarButton = new JButton("Buscar Alimentos");
        buscarButton.setBackground(new Color(141, 120, 187)); // Púrpura claro
        buscarButton.setBounds(600, 150, 200, 150);
        panel.add(buscarButton);

        // Agregar panel al frame
        frame.add(panel);
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getNotificacionButton() {
        return notificacionButton;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }
}
