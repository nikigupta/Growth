package com.amazonaws.lambda.demo;

import java.util.Scanner;

public class sortColors {
	private static Scanner sc;
	
	public void swap(int[] nums, int i, int x) {
		int temp = nums[i];
		nums[i] = nums[x];
		nums[x] = temp;
	}

	public static void sortColor(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for(int num: nums) {
        	if (num == 0) {
        		a++;
        	} else if (num == 1) {
        		b++;
        	} else if (num == 2) {
        		c++;
        	}
        } 
        int i = 0;
        while(i < a) {
        	nums[i] = 0;
        	i++;
        }
        while(i < a+b) {
        	nums[i] = 1;
        	i++;
        }
        while(i < a+b+c ) {
        	nums[i] = 2;
        	i++;
        }
    }
	
	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n) {
			arr[i] = sc.nextInt();
			i++;
		}
		sortColor(arr);
		for (int p : arr) {
			System.out.println(p);
		}
	}
}
