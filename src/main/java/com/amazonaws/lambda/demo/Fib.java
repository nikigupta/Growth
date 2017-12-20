package com.amazonaws.lambda.demo;


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Fib
{
	public static void main (String[] args) throws java.lang.Exception
	{	
		
		
		int[][] arr = new int[3][3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(minPathSum(arr));
		
		
	}

	private static int minPathSum(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int[][] res = new int[m][n];
		res[0][0] = arr[0][0];
		for (int i = 1; i < n; i++) {
			res[0][i] = arr[0][i] + res[0][i-1];
		}
		for (int j = 1; j < m; j++) {
			res[j][0] = arr[j][0] + res[j-1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = arr[i][j] + Math.min(res[i-1][j], res[i][j-1]);
			}
		}
		return res[m-1][n-1];
		
	}
	
}