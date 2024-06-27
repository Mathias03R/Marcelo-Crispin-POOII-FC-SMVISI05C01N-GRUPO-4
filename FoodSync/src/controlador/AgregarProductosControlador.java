package controlador;

import vista.AgregarProductos;
import vista.PantallaPrincipal;
import modelo.Comida;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Repository.ComidaRepository;
import Repository.FileComidaRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class AgregarProductosControlador {
    private AgregarProductos vista; // Referencia a la vista AgregarProductos
    private ComidaRepository comidaRepository; // Repositorio de Comida
    private DefaultTableModel model; // Modelo de tabla para la vista

    public AgregarProductosControlador(AgregarProductos vista) {
        this.vista = vista;
        this.comidaRepository = new FileComidaRepository(); // Inicialización del repositorio de comida
        initControlador(); // Configuración inicial del controlador
        initTableModel(); // Inicializar el modelo de tabla al crear el controlador
        actualizarTabla(); // Cargar datos existentes al inicio
    }

    private void initControlador() {
        // Configuración del ActionListener para el botón de Agregar
        vista.getAgregarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados por el usuario desde la vista
                String nombre = vista.getNombreField().getText();
                String fechaPreparacion = vista.getFechaPreparacionField().getText();
                String fechaVencimiento = vista.getFechaVencimientoField().getText();

                // Validación de campos vacíos
                if (nombre.isEmpty() || fechaPreparacion.isEmpty() || fechaVencimiento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                    return;
                }

                // Crear objeto Comida con los datos ingresados
                try {
                    // Generar un nuevo ID basado en el tamaño actual de la lista de comidas
                    Long newId = (long) (comidaRepository.findAll().size() + 1);
                    LocalDate fechaPreparacionDate = LocalDate.parse(fechaPreparacion); // Convertir fecha de
                                                                                        // preparación a LocalDate
                    LocalDate fechaVencimientoDate = LocalDate.parse(fechaVencimiento); // Convertir fecha de
                                                                                        // vencimiento a LocalDate
                    Comida nuevaComida = new Comida(newId, nombre, fechaPreparacionDate, fechaVencimientoDate);

                    // Guardar la nueva comida en el repositorio
                    comidaRepository.save(nuevaComida);
                    JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");

                    // Actualizar la tabla visual de comidas
                    actualizarTabla();

                    // Limpiar los campos de texto en la vista
                    vista.getNombreField().setText("");
                    vista.getFechaPreparacionField().setText("");
                    vista.getFechaVencimientoField().setText("");
                } catch (DateTimeParseException ex) {
                    // Capturar excepción si el formato de fecha no es válido
                    JOptionPane.showMessageDialog(null,
                            "Error al guardar el producto: Formato de fecha inválido. Usa el formato yyyy-MM-dd");
                } catch (Exception ex) {
                    // Capturar cualquier otra excepción y mostrar un mensaje genérico
                    JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + ex.getMessage());
                }
            }
        });

        // Configuración del ActionListener para el botón de Regresar
        vista.getRegresarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose(); // Cerrar la ventana actual de AgregarProductos

                // Mostrar nuevamente la PantallaPrincipal
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                new PantallaPrincipalControlador(pantallaPrincipal);
                pantallaPrincipal.getFrame().setVisible(true); // Hacer visible la PantallaPrincipal
            }
        });
    }

    // Método para inicializar el modelo de tabla
    private void initTableModel() {
        String[] columnNames = { "ALIMENTOS AGREGADOS", "F.PREPARACIÓN", "F.VENCIMIENTO" };
        Object[][] data = new Object[0][3]; // Inicializar los datos de la tabla vacíos
        model = new DefaultTableModel(data, columnNames); // Crear el modelo de tabla con los nombres de columna
        vista.getTable().setModel(model); // Establecer el modelo de tabla en la vista
    }

    // Método para actualizar la tabla con los datos actuales del repositorio
    private void actualizarTabla() {
        model.setRowCount(0); // Limpiar todas las filas existentes en el modelo
        List<Comida> comidas = comidaRepository.findAll(); // Obtener todas las comidas desde el repositorio
        for (Comida comida : comidas) {
            // Agregar cada comida como una fila en el modelo de tabla
            Object[] row = { comida.getName(), comida.getDateOfEntry(), comida.getExpirationDate() };
            model.addRow(row); // Agregar la fila al modelo de tabla
        }
    }
}