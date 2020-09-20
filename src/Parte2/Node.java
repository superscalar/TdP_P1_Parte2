package Parte2;

import java.util.ArrayList;

public class Node {
	private int rotulo;	
	private ArrayList<Edge> listaArcos;
	
	public Node(int r) {
		rotulo = r;
		listaArcos = new ArrayList<Edge>();
	}
	
	public int getRotulo() {
		return rotulo;
	}
	
	public ArrayList<Edge> getListaArcos() {
		return listaArcos;
	}
}
