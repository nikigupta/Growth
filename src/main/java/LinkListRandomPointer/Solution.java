package LinkListRandomPointer;

public class Solution {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head != null) {
			RandomListNode copyHead = new RandomListNode(head.label);
			RandomListNode copyHeadOriginal = head;
			RandomListNode temp = copyHead;
			while (copyHeadOriginal.next != null) {
				System.out.println("m here");
				temp.next = new RandomListNode(copyHeadOriginal.next.label);
				copyHeadOriginal = copyHeadOriginal.next;
				temp = temp.next;
			}
			copyHeadOriginal = head;
			temp = copyHead;
			int count = 0;
			while (copyHeadOriginal != null) {
				count = 0;
				if (copyHeadOriginal.random == null) {
					temp.random = null;

				} else {
					RandomListNode copy = head;
					RandomListNode copyTemp = copyHead;
					while (copy != null && copy != copyHeadOriginal.random) {
						count++;
						copy = copy.next;
					}
					while (count-- > 0){
						copyTemp = copyTemp.next;
					}

					temp.random = copyTemp;
				}
				copyHeadOriginal = copyHeadOriginal.next;
				temp = temp.next;
			}
			return copyHead;
		} else {
			return head;
		}

	}

	public static void main(String args[]) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode node1 = new RandomListNode(2);
		RandomListNode node2 = new RandomListNode(3);
		RandomListNode node3 = new RandomListNode(4);
		head.next = node1;
		head.random = node2;
		node1.next = node2;
		node2.next = node3;
		node2.random = node1;
		node3.random = node2;
		RandomListNode node = copyRandomList(head);
		while (node.next != null) {
			System.out.println(node.label);
			System.out.println(node.next.label);
		}
	}
}
