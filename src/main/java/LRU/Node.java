package LRU;

public class Node {
	public Node next;
	public Node prev;
	public Value val;
	
	Node(Node prev, Value val, Node next) {
		this.next = next;
		this.val = val;
		this.prev = prev;
	}
}
