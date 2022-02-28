package DP3;

/*Problem Description

Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.



Problem Constraints

1 <= length of(A) <= 103



Input Format

First and only integer is a string A.



Output Format

Return an integer denoting the length of longest palindromic subsequence.



Example Input

Input 1:

 A = "bebeeed"
Input 2:

 A = "aedsead"


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 The longest palindromic subsequence is "eeee", which has a length of 4.
Explanation 2:

 The longest palindromic subsequence is "aedea", which has a length of 5.*/

public class Longest_Palindromic_Subsequence {
	public static void main(String[] args) {
		 String A = "bebeeed";
		 StringBuffer B = new StringBuffer(A);
		 String p = B.reverse().toString();
	     int n = A.length();
	     int k =  LCS(A.toCharArray(), p.toCharArray(), n , n);
	     System.out.println(k);
	}
	static int LCS(char[] a, char[]b , int n , int m){
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i<=n; i++){
            for(int j = 0; j<=m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(a[i-1] == b[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

}
