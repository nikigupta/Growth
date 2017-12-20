package com.amazonaws.lambda.demo;

import java.util.Scanner;

public class SortColors2 {
	private static Scanner sc;
	
	public static void swap(int[] nums, int i, int x) {
		int temp = nums[i];
		nums[i] = nums[x];
		nums[x] = temp;
	}
	public static void sortColor(int[] nums) {
		int n = nums.length;
		int i = 0;
		int j = n-1;
		int x = 0;
		while (x < n) {
		while(nums[x] == 2 && x < j) {
			swap(nums, x, j);
			j--;
		}
		if(nums[x] == 0 && x >= i) {
			swap(nums, x, i);
			i++;
		}
		x++;
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
