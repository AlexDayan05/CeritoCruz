package cero_cruz;

import java.awt.EventQueue;

public class Runner {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero t = new Tablero();
					for(int i = 0; i < 9; i++){
						t.addCelda(new Celda(""));
					}
					
					Interfaz frame = new Interfaz(t);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
