package cero_cruz;

import java.util.ArrayList;

public class Tablero {
	ArrayList<Celda> celdas;
	private int turno;
	
	public Tablero(){
		turno = 0;
		celdas = new ArrayList<>();
	}
	
	public void addCelda(Celda celda){
		celdas.add(celda);
	}
	
	public void comprobarEstado(){
		if(comprobarVD()){
			
		}
		else if(comprobarEmpate()){
			
		}
	}
	
	public boolean comprobarVD(){
		return false;
		
	}
	
	public boolean comprobarEmpate(){
		return false;
	}
	
	public void siguienteTurno(Celda celda){
		if(turno%2 == 0){
			celda.setTexto("X");
		}
		else{
			celda.setTexto("0");
		}
		turno++;
	}

	public Celda getCelda(int i) {
		return celdas.get(i);
	}
}
