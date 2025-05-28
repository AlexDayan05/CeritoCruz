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

        final DefaultTableModel model = new DefaultTableModel(new Object[][] {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
            }, new String[]{"", "", ""}) {
				private static final long serialVersionUID = 1L;

				@Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            final JTable table = new JTable(model);
            table.setRowHeight(140);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());

                if (row >= 0 && column >= 0) {
                    int celdaSeleccionada = row * 3 + column;
                    Celda celda = tablero.getCelda(celdaSeleccionada); 
                    if(celda.getTexto().equals("")){
                    	tablero.siguienteTurno(celda);
                        model.setValueAt(celda.getTexto(), row, column); 
                    }   
                }
            }
        });

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
