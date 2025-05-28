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

	public boolean comprobarVD(){
		ArrayList<String> combinaciones = new ArrayList<>();
		combinaciones.add("012");
		combinaciones.add("345");
		combinaciones.add("678");
		combinaciones.add("036");
		combinaciones.add("147");
		combinaciones.add("258");
		combinaciones.add("048");
		combinaciones.add("246");

		for(String combinacion : combinaciones){


			int p1 = Integer.valueOf(combinacion.charAt(0));
			int p2 = Integer.valueOf(combinacion.charAt(1));
			int p3 = Integer.valueOf(combinacion.charAt(2));
			if(celdas.get(p1).getTexto().matches("[0X]") && celdas.get(p2).getTexto().matches("[0X]") && celdas.get(p3).getTexto().matches("[0X]")){
				if(celdas.get(p1).getTexto().equals(celdas.get(p2).getTexto()) && celdas.get(p2).getTexto().equals(celdas.get(p3).getTexto())){
					return true;
				}
			}

		}

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
