package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOdd {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int size = sc.nextInt();
			Integer[] list = new Integer[size];
			for(int i = 0; i < size; i++) {
				list[i] = sc.nextInt();
			}
			List<Integer> evenList = new ArrayList<Integer>(size);
			List<Integer> oddList = new ArrayList<Integer>(size);
			for (int i = 0; i < list.length; i++) {
				if((list[i] % 2) == 0) {
					evenList.add(list[i]);
				} else {
					oddList.add(list[i]);
				}
			}
			int sizeOdd = oddList.size();
			int sizeEven = evenList.size();
			int i = 0;
			int j = 0;
			int k = 0;
			while (j < sizeEven && k < sizeOdd) {
				if(i % 2 == 0) {
					list[i] = evenList.get(j);
					j++;
				} else {
					list[i] = oddList.get(k);
					k++;
				}
				i++;
			}
			while (j < sizeEven) {
				list[i] = evenList.get(j);
				j++;
				i++;
			}
			while (k < sizeOdd) {
				list[i] = oddList.get(k);
				k++;
				i++;
			}
			for (int z = 0; z < list.length; z++) {
				System.out.print( list[z] + " ");
			}
			System.out.println();
		}
	}
}
