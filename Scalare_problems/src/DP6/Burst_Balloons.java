package DP6;

public class Burst_Balloons {
	public static void main(String[] args) {
		int A[] = {3, 1, 5, 8};
		 int[][] dp = new int[A.length][A.length];
			for(int  g = 0; g<dp.length; g++) {
				for(int i = 0 , j= g; j<dp.length; i++, j++) {
					int max = Integer.MIN_VALUE;
					for(int k = i; k<=j; k++) {
						int left = k== i ?0: dp[i][k-1];
						int right = k == j ?0: dp[k+1][j];
						int val = A[k];
						if(i>0) {
							val = val*A[i-1];
						}
						if(j != A.length-1) {
							val = val*A[j+1];
						}
						int total = left+ right+val;
						max = Math.max(max, total);
					}
					dp[i][j] = max;
				}
			}
			System.out.println( dp[0][A.length-1]);
			
	}

}
