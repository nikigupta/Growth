package LinkList;

import java.util.Scanner;

// For a given K value(K> 0), reverse blocks of K nodes in a list

/**
 * Algorithm: 1) Find if K nodes present -Yes: return K+1Th node -No: return 2)
 * Reverse these K nodes 3) Set next of last node(after reversal) to K+1th node
 * 
 * @author nikigupta
 *
 */
public class ReverseKNodes {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ReverseKNodes rKn = new ReverseKNodes();
		Node head = rKn.createLinkList();
		print(head);
		System.out.println("Enter K");
		int k = sc.nextInt();
		Node newHead = rKn.reverseKBlocks(head, k);
		print(newHead);
	}

	private static void print(Node head) {
		System.out.println("Printing list values");
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}

	private Node reverseKBlocks(Node head, int k) {
		Node newHead = head;
		Node cur = head;
		Node prevHead = null;
		while((cur != null) && hasKNodes(cur, k)) {
			Node ptr = cur;
			Node tmp = getKPlus1thNode(cur, k);
			int i = 0;
			while (i< k) {
				Node next = cur.next;
				cur.next = tmp;
				tmp = cur;
				cur = next;
				i++;
			}
			// have to attach last node of reversed link list to first node of next reversed list
			// prevHead stores last node of previous reversed block (first node of prev unreversed list))
			// ptr stores last node of current reversed list(first node of unreversed list)
			
			// link last node of prev reverse block to current head of reversed list and update prevHead
			if (prevHead != null) {
				prevHead.next = tmp;
				prevHead = ptr;
				
			} else { // if this is first time just save first node
				prevHead = ptr;
				newHead = tmp;
			}
		}
		return newHead;
	}

	private Node getKPlus1thNode(Node head, int k) {
		int i;
		Node tmp = head;
		for (i = 0; i < k && tmp != null; i++ , tmp = tmp.next) {
			
		}
		if (i == k) {
			return tmp;
		}
		return head;
	}

	private boolean hasKNodes(Node head, int k) {
		int i;
		for (i = 0; i < k; i++) {
			if (head != null) {
				head = head.next;
			} else {
				break;
			}
		}
		if (i == k) {
			return true;
		}
		return false;
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
}
