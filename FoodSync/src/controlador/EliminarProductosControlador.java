package controlador;

import vista.EliminarProductos;
import vista.PantallaPrincipal;
import modelo.Comida;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Repository.ComidaRepository;
import Repository.FileComidaRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarProductosControlador {
    private EliminarProductos vista; // Referencia a la vista EliminarProductos
    private ComidaRepository comidaRepository; // Repositorio de Comida
    private DefaultTableModel model; // Modelo de tabla para la vista

    public EliminarProductosControlador(EliminarProductos vista) {
        this.vista = vista;
        this.comidaRepository = new FileComidaRepository(); // Inicialización del repositorio de comida
        initControlador(); // Configuración inicial del controlador
        initTableModel(); // Inicializar el modelo de tabla al crear el controlador
        actualizarTabla(); // Cargar datos existentes al inicio
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón de Confirmar
        vista.getConfirmarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String confirmacionText = vista.getConfirmarField().getText();

                // Verificar si la confirmación es correcta
                if ("CONFIRMAR".equalsIgnoreCase(confirmacionText)) {
                    DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
                    boolean hasSelectedRows = false;

                    // Iterar sobre las filas de la tabla en reversa para evitar problemas con el
                    // índice
                    for (int i = model.getRowCount() - 1; i >= 0; i--) {
                        Boolean isSelected = (Boolean) model.getValueAt(i, 4);
                        if (isSelected != null && isSelected) {
                            Long id = (Long) model.getValueAt(i, 0);
                            System.out.println("Eliminando producto con ID: " + id); // Mensaje de depuración

                            // Eliminar el producto del repositorio y de la tabla
                            comidaRepository.delete(id);
                            model.removeRow(i);
                            hasSelectedRows = true;
                        }
                    }

                    // Mostrar mensaje según si se eliminaron productos o no
                    if (hasSelectedRows) {
                        JOptionPane.showMessageDialog(vista.getFrame(), "Producto(s) eliminado(s) exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(vista.getFrame(), "No se seleccionaron productos para eliminar.");
                    }

                    // Limpiar el campo de confirmación después de la operación
                    vista.getConfirmarField().setText("");
                } else {
                    JOptionPane.showMessageDialog(vista.getFrame(),
                            "Por favor, escriba la palabra \"CONFIRMAR\" para eliminar el producto.");
                }
            }
        });

        // Configuración del ActionListener para el botón de Regresar
        vista.getRegresarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose(); // Cerrar la ventana actual de EliminarProductos

                // Mostrar nuevamente la PantallaPrincipal
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                new PantallaPrincipalControlador(pantallaPrincipal);
                pantallaPrincipal.getFrame().setVisible(true); // Hacer visible la PantallaPrincipal
            }
        });
    }

    // Método para inicializar el modelo de tabla
    private void initTableModel() {
        String[] columnNames = { "ID", "NOMBRE", "F.PREPARACIÓN", "F.VENCIMIENTO", "SELECCIONAR" };
        Object[][] data = new Object[0][5]; // Datos de la tabla inicialmente vacíos
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class; // Configurar la columna de selección como tipo Booleano
                }
                return String.class; // Las demás columnas son de tipo String
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Permitir editar solo la columna de selección
            }
        };
        vista.getTable().setModel(model); // Establecer el modelo de tabla en la vista EliminarProductos
    }

    // Método para actualizar la tabla con la lista de comidas desde el repositorio
    private void actualizarTabla() {
        model.setRowCount(0); // Limpiar todas las filas existentes en el modelo
        List<Comida> comidas = comidaRepository.findAll(); // Obtener todas las comidas desde el repositorio
        for (Comida comida : comidas) {
            // Agregar cada comida como una fila en el modelo de tabla
            Object[] row = { comida.getId(), comida.getName(), comida.getDateOfEntry(), comida.getExpirationDate(),
                    false };
            model.addRow(row);
        }
    }
}
