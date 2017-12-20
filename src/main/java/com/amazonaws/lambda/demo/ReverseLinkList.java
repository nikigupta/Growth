package com.amazonaws.lambda.demo;

import LinkList.Node;

public class ReverseLinkList {
	public static Node reverseList(Node head) {
		Node current = head;
		if (head == null) {
			return null;
		}
		Node tmp = head.next;
		Node nextNode = head;
		while (tmp != null) {
			nextNode = tmp;
			tmp = nextNode.next;
			nextNode.next = current;
			current = nextNode;
		}
		head.next = null;
		head = current;
		return head;
	}

	public static void main(String args[]) {
		Node n = new Node(1);
		n.next = new Node(2);
		Node newnode = reverseList(n);
		print(newnode);
		// System.out.println(newnode);
	}

	private static void print(Node newnode) {
		while (newnode != null) {
			System.out.println(newnode.data);
			newnode = newnode.next;
		}

	}
}
