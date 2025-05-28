package cero_cruz;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Interfaz extends JFrame {
    private Tablero tablero;

    public Interfaz(final Tablero tablero) {
        this.tablero = tablero; 
        JFrame frame = new JFrame("Tablero de 0X");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);

        String[] columnNames = {"", "", ""};
        final DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        final JTable table = new JTable(model);

        table.setRowHeight(140);
        for (int i = 0; i < 3; i++) {
            model.addRow(new Object[]{"", "", ""});
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());

                if (row >= 0 && column >= 0) {
                    int celdaSeleccionada = row * 3 + column;
                    Celda celda = tablero.getCelda(celdaSeleccionada); 
                    tablero.siguienteTurno(celda);
                    model.setValueAt(celda.getTexto(), row, column); 
                }
            }
        });

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
