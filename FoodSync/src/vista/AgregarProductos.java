package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AgregarProductos {
    private JFrame frame;
    private JTextField nombreField;
    private JTextField fechaPreparacionField;
    private JTextField fechaVencimientoField;
    private JButton agregarButton;
    private JButton regresarButton;
    private JButton notificacionButton;
    private JTable table;

    public AgregarProductos() {
        // Crear el frame
        frame = new JFrame("FoodSync");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Panel superior para los campos de entrada y botón
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null); // Desactivar el layout manager predeterminado
        inputPanel.setBounds(10, 10, 870, 180);

        // Campos de entrada
        nombreField = new JTextField();
        nombreField.setBounds(300, 20, 200, 30);

        fechaPreparacionField = new JTextField();
        fechaPreparacionField.setBounds(300, 60, 200, 30);

        fechaVencimientoField = new JTextField();
        fechaVencimientoField.setBounds(300, 100, 200, 30);

        // Etiquetas
        JLabel nombreLabel = new JLabel("Ingrese el nombre del alimento:");
        nombreLabel.setBounds(20, 20, 180, 30);

        JLabel fechaPreparacionLabel = new JLabel("Ingrese la fecha de preparación del producto:");
        fechaPreparacionLabel.setBounds(20, 60, 280, 30);

        JLabel fechaVencimientoLabel = new JLabel("Ingrese la fecha de vencimiento del producto:");
        fechaVencimientoLabel.setBounds(20, 100, 280, 30);

        // Botón agregar
        agregarButton = new JButton("Agregar");
        agregarButton.setBackground(new Color(154, 191, 155));
        agregarButton.setBounds(550, 20, 100, 40);

        // Botón de regresar a la PantallaPrincipal
        regresarButton = new JButton("↤");
        regresarButton.setBounds(800, 120, 50, 40);
        regresarButton.setBackground(new Color(217, 217, 217));
        inputPanel.add(regresarButton);

        // Agregar componentes al panel de entrada
        inputPanel.add(nombreLabel);
        inputPanel.add(nombreField);
        inputPanel.add(fechaPreparacionLabel);
        inputPanel.add(fechaPreparacionField);
        inputPanel.add(fechaVencimientoLabel);
        inputPanel.add(fechaVencimientoField);
        inputPanel.add(agregarButton);

        // Agregar el panel de entrada al frame
        frame.add(inputPanel);

        // Tabla para mostrar los alimentos agregados
        String[] columnNames = { "ALIMENTOS AGREGADOS", "F.PREPARACIÓN", "F.VENCIMIENTO" };
        Object[][] data = new Object[0][3];
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 200, 870, 280);

        // Agregar la tabla al frame
        frame.add(scrollPane);

        // Mostrar el frame
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getFechaPreparacionField() {
        return fechaPreparacionField;
    }

    public JTextField getFechaVencimientoField() {
        return fechaVencimientoField;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }

    public JTable getTable() {
        return table;
    }
}
