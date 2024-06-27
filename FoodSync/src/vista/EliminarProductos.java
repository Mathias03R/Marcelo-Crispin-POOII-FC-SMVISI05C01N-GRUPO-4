package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class EliminarProductos {
    private JFrame frame;
    private JTable table;
    private JTextField confirmarField;
    private JButton confirmarButton;
    private JButton regresarButton;

    public EliminarProductos() {
        // Crear el frame
        frame = new JFrame("Eliminar Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Panel superior para la etiqueta y la tabla
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(10, 10, 870, 400);

        // Etiqueta
        JLabel selectLabel = new JLabel("SELECCIONE EL PRODUCTO A ELIMINAR");
        selectLabel.setBounds(10, 10, 300, 30);
        topPanel.add(selectLabel);

        // Modelo de tabla para permitir la edición de datos
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Producto", "F. Preparación", "F. Vencimiento", "Seleccionar" }) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        // Tabla para mostrar los alimentos agregados
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 850, 340);
        topPanel.add(scrollPane);

        // Agregar el panel superior al frame
        frame.add(topPanel);

        // Panel inferior para el campo de texto y el botón
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(10, 420, 870, 40);
        frame.add(bottomPanel);

        // Campo de texto para confirmar
        confirmarField = new JTextField();
        confirmarField.setBounds(10, 5, 250, 30);
        bottomPanel.add(confirmarField);

        // Etiqueta para confirmar
        JLabel confirmarLabel = new JLabel("Escriba la palabra \"CONFIRMAR\" para eliminar el producto");
        confirmarLabel.setBounds(270, 4, 400, 30);
        bottomPanel.add(confirmarLabel);

        // Botón confirmar
        confirmarButton = new JButton("CONFIRMAR");
        confirmarButton.setBackground(new Color(154, 191, 155));
        confirmarButton.setBounds(640, 4, 140, 30);
        bottomPanel.add(confirmarButton);

        // Botón de regresar a la PantallaPrincipal
        regresarButton = new JButton("↤");
        regresarButton.setBounds(810, 4, 50, 30);
        regresarButton.setBackground(new Color(217, 217, 217));
        bottomPanel.add(regresarButton);

        // Mostrar el frame
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }

    public JTextField getConfirmarField() {
        return confirmarField;
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }
}
