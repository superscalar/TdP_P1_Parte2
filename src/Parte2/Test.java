package Parte2;

public class Test {
	public static void main(String[] args) { 
		Graph g = new Graph();
		
		g.addNode(31);
		g.addNode(54);
		g.addNode(61);
		g.addNode(71);
		
		g.addEdge(31, 71);
		
		g.addEdge(71, 64); // Arco a un nodo que no existe
		g.addEdge(64, 54); // Arco a un nodo que no existe
		
		g.removeEdge(71, 31); // Eliminar arco inexistente
		g.removeEdge(31, 71);
		
		g.removeNode(54);
		g.removeNode(31);
		
		g.addEdge(31, 61); // Arco a un nodo eliminado
	}
}




















