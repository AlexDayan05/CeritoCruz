package cero_cruz;

import java.util.ArrayList;

public class Tablero {
	ArrayList<Celda> celdas;
	private int turno;
	
	public Tablero(){
		celdas = new ArrayList<>();
	}
	
	public void addCelda(Celda celda){
		celdas.add(celda);
	}
	
	public void comprobarEstado(){
		
	}
	
	public boolean comprobarVD(){
		return false;
		
	}
	
	public boolean comprobarEmpate(){
		return false;
		
	}
	
	public void siguienteTurno(){
		turno++;
	}
}
