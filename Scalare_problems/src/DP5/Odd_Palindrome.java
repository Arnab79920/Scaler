package DP5;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
Given a string A, find if there is any subsequence that repeats itself.

A subsequence of a string is defined as a sequence of characters generated by deleting some characters in the string without changing the order of the remaining characters.

NOTE:
1. Subsequence length should be greater than or equal to 2.
2. The repeating subsequence should be disjoint that is no index in the original subsequence should be present in the repeated subsequence.



Problem Constraints
1 <= length(A) <= 100



Input Format
The first and the only argument of input contains a string A.



Output Format
Return an integer, 1 if there is any subsequence which repeat itself else return 0.



Example Input
Input 1:

 A = "abab"
Input 2:

 A = "abba"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 "ab" is repeated.
Explanation 2:

 There is no repeating subsequence.*/

public class Odd_Palindrome {
	static int m = 10000007;
	public static void main(String[] args) {
       String A = "xyzx";
		
		ArrayList<Integer>li = new ArrayList<>();
		int n = A.length();
		int[][] dp= new int[n+1][n+1];
		for(int[] a : dp) {
			Arrays.fill(a, -1);
		}
		int ans[] = new int[A.length()];
		Arrays.fill(ans, 1);
		for(int i = 0; i<n; i++ ) {
			ans[i] +=func(i-1, i+1, A, dp);
		}
		for(int a :ans) {
			System.out.println(a);
		}
		
	}
	
	static int func(int i , int j, String A, int[][] dp) {
		if(i<0 || j==A.length()) return 0;
		int ans = 0;
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		
		else if(A.charAt(i) == A.charAt(j)) {
			ans = 1;
			ans += func(i, j+1, A, dp);
			ans += func(i-1, j, A, dp);
		}
		else {
			ans += func(i, j+1, A, dp);
			ans += func(i-1, j, A, dp);
			ans -= func(i-1, j+1, A, dp);
			ans = (ans+m)%m;
		}
		 return dp[i][j] = ans%m;
		
	}
		
	}


