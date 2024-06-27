package controlador;

import java.util.ArrayList;
import vista.BuscarProducto;
import vista.PantallaPrincipal;
import modelo.Comida;
import javax.swing.table.DefaultTableModel;

import Repository.ComidaRepository;
import Repository.FileComidaRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarProductoControlador {
    private BuscarProducto vista; // Referencia a la vista BuscarProducto
    private ComidaRepository comidaRepository; // Repositorio de Comida
    private DefaultTableModel model; // Modelo de tabla para la vista

    public BuscarProductoControlador(BuscarProducto vista) {
        this.vista = vista;
        this.comidaRepository = new FileComidaRepository(); // Inicialización del repositorio de comida
        initControlador(); // Configuración inicial del controlador
        initTableModel(); // Inicializar el modelo de tabla al crear el controlador
        actualizarTabla(comidaRepository.findAll()); // Actualizar tabla con todas las comidas existentes
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón de Buscar
        vista.getBuscarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreProducto = vista.getParametroField().getText(); // Obtener el nombre del producto a
                                                                                 // buscar
                    List<Comida> resultados = buscarProductoPorNombre(nombreProducto); // Buscar productos por nombre
                    actualizarTabla(resultados); // Actualizar la tabla con los resultados
                } catch (Exception ex) {
                    ex.printStackTrace(); // Imprimir la traza de la excepción en caso de error
                }
            }
        });

        // Configuración del ActionListener para el botón de Regresar
        vista.getRegresarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose(); // Cerrar la ventana actual de BuscarProducto

                // Mostrar nuevamente la PantallaPrincipal
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                new PantallaPrincipalControlador(pantallaPrincipal);
                pantallaPrincipal.getFrame().setVisible(true); // Hacer visible la PantallaPrincipal
            }
        });
    }

    // Método para buscar productos por nombre en la lista de comidas
    private List<Comida> buscarProductoPorNombre(String nombre) {
        List<Comida> resultados = new ArrayList<>(); // Lista para almacenar los resultados de la búsqueda
        List<Comida> comidas = comidaRepository.findAll(); // Obtener todas las comidas desde el repositorio

        for (Comida comida : comidas) {
            if (comida.getName().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(comida); // Agregar la comida al resultado si el nombre coincide (ignorando
                                        // mayúsculas/minúsculas)
            }
        }

        return resultados; // Devolver la lista de resultados de la búsqueda
    }

    // Método para inicializar el modelo de tabla
    private void initTableModel() {
        String[] columnNames = { "ID", "NOMBRE", "F.PREPARACIÓN", "F.VENCIMIENTO" };
        Object[][] data = new Object[0][4]; // Datos de la tabla inicialmente vacíos
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class; // Configurar la columna 4 (posición 3) como tipo Booleano
                }
                return String.class; // Las demás columnas son de tipo String
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Permitir editar solo la columna 4 (posición 3)
            }
        };
        vista.getTable().setModel(model); // Establecer el modelo de tabla en la vista BuscarProducto
    }

    // Método para actualizar la tabla con la lista de comidas proporcionada
    private void actualizarTabla(List<Comida> comidas) {
        model.setRowCount(0); // Limpiar todas las filas existentes en el modelo
        for (Comida comida : comidas) {
            Object[] row = { comida.getId(), comida.getName(), comida.getDateOfEntry(), comida.getExpirationDate() };
            model.addRow(row); // Agregar cada comida como una fila en el modelo de tabla
        }
    }
}