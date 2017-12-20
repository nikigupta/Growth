package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shumishra on 6/13/17.
 */
public class TestLCA {

    public static void main(String[] args) {
        Node root = createBinaryTree();
        List<Node> pathtoN1 = new ArrayList<>();
        List<Node> pathtoN2 = new ArrayList<>();
        traverse(root,pathtoN1, 19);
        traverse(root,pathtoN2, 3);
        print(pathtoN1);
        print(pathtoN2);
        System.out.println(find(pathtoN1,pathtoN2 ).data);
//        System.out.println(LCA(root, 3,19));
//        System.out.println(efficientLCA(root, 3,19).data);
    }
	private static Node find(List<Node> pathtoN1, List<Node> pathtoN2) {
		Node lca = pathtoN1.get(0);
		int i;
		for (i = 1; i < pathtoN1.size() && i< pathtoN2.size(); i++) {
			if (pathtoN1.get(i).data != pathtoN2.get(i).data) {
				return lca;
			}
			lca =pathtoN1.get(i);
		}
		return lca;
		
	}
	static boolean traverse(Node root, List<Node> path, int x) {
	    if(root == null) {
	        return false;
	    }
	    if(root.data == x) {
	    	 path.add(root);
	        return true;
	    }
	    path.add(root);
	    if (traverse(root.left, path, x)) {
	        return true;
	    }
	    if(traverse(root.right, path, x)) {
	        return true;
	    }
	    path.remove(path.size()-1);
	    return false;
	}


    
	
	
//    private static char[] LCA(Node root, int i, int j) {
//		
//	}





	private static Node createBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);


        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(3);
        root.right.right = new Node(19);

        return root;
    }

    private static void print(List<Node> arrayList) {
        arrayList.forEach( it -> System.out.print(it.data + "  "));
        System.out.println("\n");
    }
}