package Arrays;

import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

public class TripletSumZero {
	public static void main(String args[]) {
		TripletSumZero tsz = new TripletSumZero();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = tsz.findTriplets(arr, n) ? 1 : 0;
			System.out.println(ans);
		}
	}

	public boolean findTriplets(int arr[] , int n)
    {
	  Arrays.sort(arr);
	  for (int i = 0; i < n; i++) {
		  int part = arr[i];
		  int remaining = -part;
		  int j = i+1;
		  int k = n-1;
		  while (j < k) {
			  int sum = arr[j] + arr[k];
			  if (sum == remaining) {
				  return true;
			  } else if (sum > remaining) {
				  k--;
			  } else {
				  j++;
			  }
		  }
	  }
      return false;
    }
	
}
