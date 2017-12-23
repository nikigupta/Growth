package Arrays;

import java.util.Scanner;

public class LargestSubarray {
	public static void main(String args[]) {
		LargestSubarray lsa = new LargestSubarray();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = lsa.maxLen(arr, n);
			System.out.println(ans);
		}
	}
	
	int maxLen(int arr[], int n)
	{
		int size = arr.length;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			int sum = arr[i];
			for (int j = i+1; j < n; j++) {
				sum += arr[j];
				if(sum == 0) {
					max = Math.max(max, j-i+1);
				}
			}
		}
		return max;
	}
}
