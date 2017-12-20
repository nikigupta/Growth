package LRU;

public class DoublyLinkList {
	Node first;
	Node last;
	transient int size = 0;
	int curSize = 0;
	public DoublyLinkList(int size) {
		this.size = size;
	}
	
	public Node addFirst(Value x) {
		Node newNode = new Node(null, x, first);
		addFirst(newNode);
		return newNode;
	}
	
	public void addFirst(Node newNode) {
		Node temp = first;
		first = newNode;
		if (temp != null) {
			temp.prev = first;
		} else {
			last = newNode;
		}
		curSize++;
	}
	 
	public Node updateMostRecentlyUsed(Node item) {
		// if it is the first node
		if (item != first) {
			unlink(item);
			addFirst(item);
		}
		return item;
	}

	public void unlink(Node item) {
		if (item == first) {
			unlinkFirst();
		} else if (item == last) {
			unlinkLast();
		} else {
			item.prev.next = item.next;
			item.next.prev = item.prev;
			curSize--;
		}
	}

	public void unlinkFirst() {
		if (first != null) {
			first = first.next;
			curSize--;
		}
	}

	public Node unlinkLast() {
		Node tmp = last;
		if (last != null) {
			last = tmp.prev;
			curSize--;
		}
		return tmp;
	}

}
