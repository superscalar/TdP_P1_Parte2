package Parte2;

public class Edge {
	private Node head, tail;
	
	public Edge(Node h, Node t) {
		head = h;
		tail = t;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node n) {
		head = n;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void setTail(Node n) {
		tail = n;
	}
}
