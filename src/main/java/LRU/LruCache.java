package LRU;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
	DoublyLinkList pageList;
	Map<Integer, Node> pageMap;

	public LruCache(int cacheSize) {
		pageList = new DoublyLinkList(cacheSize);
		pageMap = new HashMap<>();
	}

	public static void main(String args[]) {
		LruCache lru = new LruCache(1);
		lru.set(100, 2);
		lru.set(200, 6);
		lru.set(300, 1);
		lru.set(200, 90);
		lru.set(2, 90);
		lru.set(3, 90);
		lru.set(0, 90);
		lru.set(20, 90);
		System.out.println(lru.get(200));
		// print(lru);
	}

	

	public int get(int x) {
		Node item = pageMap.get(x);
		// if value is not null get item and update cache
		if (item != null) {
			Integer value = item.val.value;
			pageList.updateMostRecentlyUsed(item);
			return value;
		} else {
			return -1;
		}
	}

	public void set(int x, int y) {
		System.out.println("Size: " + pageList.curSize);
		Value value = new Value(x, y);
		Node item = pageMap.get(x);
		Node node;
		if (item != null) {
			item.val = value;
			node = pageList.updateMostRecentlyUsed(item);
		} else {
			if (pageList.curSize < pageList.size) {
				node = pageList.addFirst(value);
			} else {
				Node toRemove = pageList.unlinkLast();
				pageMap.remove(toRemove.val.key);
				node = pageList.addFirst(value);
			}
		}
		pageMap.put(x, node);

	}
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
			newNode.prev = null;
			newNode.next = first;
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
				if (first != null) {
					first.prev = null;
				} else {
					last = null;
				}
				curSize--;
			}
		}

		public Node unlinkLast() {
			Node tmp = last;
			if (tmp != null) {
				last = tmp.prev;
				if (last != null) {
					last.next = null;
				} else {
					first = null;
				}
				curSize--;
			}
			return tmp;
		}

	}

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

	public class Value {
		public Integer key;
		public Integer value;

		public Value(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
