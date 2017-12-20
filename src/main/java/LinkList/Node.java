package LinkList;

import java.util.ArrayList;

public class Node {
	public Node next;
	public int data;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	static int intersectPoint(Node headA, Node headB)
	{
		ArrayList<Node> a = new ArrayList<>();
		ArrayList<Node> b = new ArrayList<>();
		storePath(headA, a);
		storePath(headB, b);
		int sizeA = a.size()-1;
		int sizeB = b.size()-1;
		Node temp = null;
		while (sizeA >= 0 && sizeB >= 0) {
			if(a.get(sizeA) == b.get(sizeB)) {
				temp = a.get(sizeA);
			}else {
				return temp.data;
			}
			sizeA--;
			sizeB--;
		}
		return -1;
	}
	
	private static void storePath(Node headA, ArrayList<Node> a) {
		while(headA != null) {
			a .add(headA);
			headA = headA.next;
		}
		
	}
	public static void main(String args[]) {
		Node n = new Node(3);
		n.next = new Node(6);
		n.next.next = new Node(9);
		n.next.next.next = new Node(15);
		n.next.next.next.next = new Node(30);
		Node n1 = new Node(10);
		n1.next = n.next.next.next;
		System.out.println(intersectPoint(n, n1));
	}

}

