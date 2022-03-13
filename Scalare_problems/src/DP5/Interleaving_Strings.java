package DP5;

import java.util.Arrays;

/*Problem Description

Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints

1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.



Output Format

Return 1 if string C is formed by interleaving of A and B else 0.



Example Input

Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
Explanation 2:

 It is not possible to get C by interleaving A and B.*/

public class Interleaving_Strings {
	public static void main(String[] args) {
		String A = "kQMi2G2DP4lDVycU2kraW49wnJ5oNQ5szn7tZ7aMA8sM";
		String B = "J2qof422vinqzNsJIylQEZllxeSD";
		String C = "Jk2qof4Q2M2vi2Gi2nDqP4zNsJlDIyVylQEcUZ2llkrxaWe49SwDnJ5oNQ5szn7tZ7aMA8sM";
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int[] a : dp) {
			Arrays.fill(a, -1);
		}
		int p = func(A, B, C, 0, 0, 0, dp);
		System.out.println(p);
	}
	
	static int func(String A, String B, String C, int i , int j , int k, int[][] dp) {
		if( i == A.length() && j == B.length() && k == C.length()) return 1;
		if(k>=C.length()) return 0;
		int result = 0;
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		if(i<A.length() && C.charAt(k)==A.charAt(i)) {
			result |= func(A, B, C, i+1, j, k+1, dp);
		}
		 if(j<B.length() && C.charAt(k) == B.charAt(j)) {
			result |= func(A, B, C, i, j+1, k+1, dp);
		}
	    
		return dp[i][j] = result;
		
		
		
		
	}
	

}
