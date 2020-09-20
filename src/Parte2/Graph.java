package Parte2;

import java.util.logging.*;
import java.util.ArrayList;

/**
 * Grafo dirigido no pesado
 * Cada nodo se identifica de forma unica con un rotulo de tipo entero
 */
public class Graph {
	private static Logger logger;
	
	private ArrayList<Node> nodos;
	private ArrayList<Edge> arcos;
	
	public Graph() {
		nodos = new ArrayList<Node>();
		arcos = new ArrayList<Edge>();
		
		// Asegurarse de inicializar un solo logger para todas las instancias de Graph
		if (logger == null) {
			logger = Logger.getLogger(Graph.class.getName());
			Handler handler = new ConsoleHandler();
			
			handler.setLevel(Level.FINE);
			logger.addHandler(handler);
			
			logger.setLevel(Level.WARNING);
			 
			// Se desactivan los handlers del logger raiz (padre del atributo logger de this)
			// para impedir que algunos logs se impriman dos veces.
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
		
		logger.info("Grafo inicializado correctamente");
	}
	
	public void addNode(int node) {
		Node n = new Node(node);
		
		Node x = encontrarNodo(node);
		if (x != null) {
			logger.warning("El nodo con rotulo " + node + " ya existe");
		} else {
			nodos.add(n);
			logger.fine("Nodo con rotulo " + node + " agregado al grafo");
		}

	}
	
	public void addEdge (int node1, int node2) {
		Node n1, n2;
		ArrayList<Edge> listaN1, listaN2;
		
		n1 = encontrarNodo(node1);
		n2 = encontrarNodo(node2);
		
		if ((n1 == null) || (n2 == null)) {
			logger.warning("Alguno de los dos nodos a unir por un arco no existen");
		} else {
			Edge e = new Edge(n1, n2);
			arcos.add(e);
			
			listaN1 = n1.getListaArcos();
			listaN2 = n2.getListaArcos();
			
			listaN1.add(e);
			listaN2.add(e);
			
			logger.fine("Creado un nuevo arco entre los nodos " + node1 + " y " + node2);
		}
	}
	
	private Node encontrarNodo(int n) {
		Node nodo = null;
		
		for (Node k : nodos) {
			if (k.getRotulo() == n) {
				nodo = k;
				break;
			}
		}
		
		return nodo;
	}
	
	public void removeNode(int node) {
		Node n1;
		ArrayList<Edge> listaArcos;
		
		n1 = encontrarNodo(node);
		
		if (n1 == null) {
			logger.warning("El nodo " + node + " a eliminar no existe");
		} else {
			listaArcos = n1.getListaArcos();
			
			// Cuando se elimina un nodo, hay que
			// eliminar todos sus arcos incidentes
			// y emergentes
			for (Edge e : listaArcos) {
				arcos.remove(e);
			}
			
			nodos.remove(n1);			
			logger.fine("Eliminado el nodo " + node);
		}
	}
	
	// node1 es el nodo desde donde emerge el arco
	// node2 es el nodo donde incide el arco
	public void removeEdge(int node1, int node2) {
		Node n1, n2;
		Edge arco;
		
		n1 = encontrarNodo(node1);
		n2 = encontrarNodo(node2);
		
		if ((n1 == null) || (n2 == null)) {
			logger.warning("Alguno de los nodos que conforman el arco a eliminar no existen");
		} else {
		
			arco = encontrarArco(n1, n2);
			
			if (arco == null) {
				logger.warning("El arco a eliminar no existe");
			} else {
				arcos.remove(arco);
				logger.fine("Arco que conecta " + node1 + " y " + node2 + " eliminado");
			}
		
		}
	}
	
	private Edge encontrarArco(Node n1, Node n2) {
		Node head, tail;
		Edge arco = null;
		
		for (Edge e : arcos) {
			head = e.getHead();
			tail = e.getTail();
			if ((head != null && tail != null)
			   && (head.equals(n1) && tail.equals(n2))) {
					arco = e;
					break;
				}
			}
		
		return arco;
	}
}
