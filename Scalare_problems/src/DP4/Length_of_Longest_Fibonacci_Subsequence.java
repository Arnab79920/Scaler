package DP4;

import java.util.HashMap;
import java.util.Map;

public class Length_of_Longest_Fibonacci_Subsequence {
	public static void main(String[] args) {
		int[] A = {1, 3, 7, 11, 12, 14, 18};
		Map<Integer, Integer> map = new HashMap<>();
		for(int i= 0; i<A.length; i++) {
			map.put(A[i], i);
		}
		int ans = 0;
		int[][] dp = new int[A.length][A.length];
		for(int k = 0; k<A.length; k++) {
			for(int j  =0 ; j<k; j++) {
				if(A[k]-A[j]<A[j] && map.containsKey(A[k]- A[j])) {
					int i = map.get(A[k]- A[j]);
					dp[j][k] = dp[i][j]+1;
					ans = Math.max(ans, dp[j][k]+2);
					
				}
			}
			
		}
		if(ans>=3) {
			System.out.println(ans);
		}
	}

}
