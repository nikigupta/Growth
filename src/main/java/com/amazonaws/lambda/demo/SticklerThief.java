package com.amazonaws.lambda.demo;

import java.util.Scanner;

public class SticklerThief {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
	    	int n = sc.nextInt();
	    	int[] arr = new int[n]; 
	    	for (int i = 0; i < n; i++) {
	    		arr[i] = sc.nextInt();
	    	}
	    	int max = arr[0];;
	    	if(n == 1) {
	    		System.out.println(max);
	    		break;
	    	}
	    	max = Math.max(arr[0], arr[1]);
	    	for (int i = 2; i < n; i++) {
	    		max = Math.max(arr[i-1], arr[i]+arr[i-2]);
	    		arr[i] = max;
	    	}
	    	System.out.println(max);
	    }
	}
}
