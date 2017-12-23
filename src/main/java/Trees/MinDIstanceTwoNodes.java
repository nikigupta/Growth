package Trees;

import java.util.Scanner;

public class MinDIstanceTwoNodes {
	
	public static void main(String args[]) {
		MinDIstanceTwoNodes min = new MinDIstanceTwoNodes();
		Scanner sc = new Scanner(System.in);
		Node root = min.createBinaryTree();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(min.findDist(root, a, b));
	}
	
	private  Node createBinaryTree() {
		Node root = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		root.left = node1;
		node1.left = node2;
		node2.left = node3;
		node1.right = node4;
		return null;
	}

	int findDist(Node root, int a, int b)
    {
        return 0;
    }
	
}
