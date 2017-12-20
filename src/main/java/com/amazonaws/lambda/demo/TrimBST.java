package com.amazonaws.lambda.demo;

public class TrimBST {
	 
	 private static Node trimBST(Node root, int low, int high) {
		if(root == null) {
			return root;
		}
		if(root.data > high) {
			return trimBST(root.left, low, high);
		}
		if(root.data < low) {
			return trimBST(root.right, low, high);
		}
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
		
	}
	public static void main(String[] args) {
	        Node root = createBinarySTree();
	        int l = 0;
	        int r = 1;
	        Node head = trimBST(root, l, r);
	        System.out.println(head.data);
	        
	 }
	 private static Node createBinarySTree() {
	        Node root = new Node(3);
	        root.left = new Node(0);
	        root.right = new Node(4);

	        
	        root.left.right = new Node(2);
	        root.left.right.left = new Node(1);
//	        root.right.left = new Node(3);
//	        root.right.right = new Node(19);

	        return root;
	    }
}
