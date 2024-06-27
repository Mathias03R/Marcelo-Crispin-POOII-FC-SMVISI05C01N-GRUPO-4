package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BuscarProducto {
    private JFrame frame;
    private JTextField parametroField;
    private JButton buscarButton;
    private JButton regresarButton;
    private JTable table;

    public BuscarProducto() {
        // Crear el frame
        frame = new JFrame("Buscar Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Panel para los campos de entrada y botones
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 880, 120);

        // Etiqueta y campo de parámetro
        JLabel parametroLabel = new JLabel("Ingrese el nombre del producto:");
        parametroLabel.setBounds(20, 19, 200, 30);
        panel.add(parametroLabel);

        parametroField = new JTextField();
        parametroField.setBounds(300, 20, 200, 30);
        panel.add(parametroField);

        // Botón buscar
        buscarButton = new JButton("Buscar");
        buscarButton.setBackground(new Color(154, 191, 155));
        buscarButton.setBounds(520, 20, 100, 35);
        panel.add(buscarButton);

        // Botón de regresar a la PantallaPrincipal
        regresarButton = new JButton("↤");
        regresarButton.setBounds(800, 80, 50, 40);
        regresarButton.setBackground(new Color(217, 217, 217));
        panel.add(regresarButton);

        // Agregar panel al frame
        frame.add(panel);

        // Modelo de tabla para mostrar resultados de búsqueda
        String[] columnNames = { "Producto", "F. Preparación", "F. Vencimiento" };
        Object[][] data = new Object[0][3]; // Tabla inicialmente vacía

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 140, 880, 320);

        // Agregar tabla al frame
        frame.add(scrollPane);

        // Mostrar el frame
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getParametroField() {
        return parametroField;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }

    public JTable getTable() {
        return table;
    }
}
