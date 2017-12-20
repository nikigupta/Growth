package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int data;
    public Node left;
    public Node right;

   public Node(int data) {
        this.data = data;
    }
   
   public static void main(String args[]) {
	   List<String> s = new ArrayList<String>();
	   System.out.println(s);
	   String[] s1 = new String[0];
	   System.out.println(s1);
	   Object o = new Object();
	   System.out.println(o);
   }
   
   
}