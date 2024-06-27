package vista;

import Observer.Notificacion;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PantallaNotificaciones {
    private JFrame frame;
    private JList<String> notificationList;

    public PantallaNotificaciones() {
        // Crear el frame
        frame = new JFrame("Notificaciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear lista de notificaciones
        notificationList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(notificationList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Agregar panel al frame
        frame.add(panel);
    }

    public void showNotifications(List<Notificacion> notifications) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Notificacion notification : notifications) {
            listModel.addElement(notification.getTitle() + ": " + notification.getDescription());
        }
        notificationList.setModel(listModel);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JList<String> getNotificationList() {
        return notificationList;
    }
}
