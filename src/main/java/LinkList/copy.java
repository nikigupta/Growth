package LinkList;

import java.util.Scanner;

public class copy {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		copy rKn = new copy();
		Node head = rKn.createLinkList();
		print(head);
		System.out.println("Enter K");
		int k = sc.nextInt();
		Node newHead = rKn.reverse(head, k);
		print(newHead);
	}
	
	private static void print(Node head) {
		System.out.println("Printing list values");
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}
	private Node createLinkList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of link list: ");
		int size = sc.nextInt();
		System.out.println("Enter values: ");
		int value = sc.nextInt();
		Node head = new Node(value);
		Node tmp = head;
		while (size-- > 1) {
			value = sc.nextInt();
			Node n = new Node(value);
			tmp.next = n;
			tmp = tmp.next;
		}
		return head;
	}
	
	Node getKPlus1ThNode(int k, Node head) {
		Node kth;
		int i = 0;
		if(head == null) {
			return head;
		}
		for (i = 0, kth = head; kth != null && (i <k); i++, kth = kth.next);
		if (i == k && kth != null) {
			return kth;
		}
		return head.next;
	}
	
	boolean hasKnodes(Node head, int k) {
		int i = 0;
		for (i = 0; head != null && (i < k); i++, head = head.next);
		if (i == k) {
			return true;
		}
		return false;
	}
	
	Node reverse(Node head, int k) {
		Node cur = head, tmp, next, newHead;
		int i;
		if(k == 0 || k == 1) {
			return head;
		}
		if (hasKnodes(cur, k-1)) {
			newHead = getKPlus1ThNode(k-1, cur);
		} else {
			newHead = head;
		}
		while (cur != null && hasKnodes(cur, k)) {
			tmp = getKPlus1ThNode(k, cur);
			i = 0;
			while (i < k) {
				next = cur.next;
				cur.next = tmp;
				tmp = cur;
				cur = next;
				i++;
			}
		}
		return newHead;
	}
}
