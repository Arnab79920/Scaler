package DP4;

/*Problem Description

Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.



Problem Constraints

1 <= length(A) <= 750000



Input Format

The only argument given is string A.



Output Format

Return the length of the longest valid (well-formed) parentheses substring.



Example Input

Input 1:

 A = "(()"
Input 2:

 A = ")()())"


Example Output

Output 1:

 2
Output 2:

 4


Example Explanation

Explanation 1:

 The longest valid parentheses substring is "()", which has length = 2.
Explanation 2:

 The longest valid parentheses substring is "()()", which has length = 4.*/

public class Longest_valid_Parentheses {
	public static void main(String[] args) {
		String A =")()())";
		 int[] dp = new int[A.length()];
	       dp[0] = 0;
	       int ans = 0;
	       for(int i = 1; i<A.length(); i++){
	           if(A.charAt(i)== '('){
	               dp[i] =  0;
	           }
	           else{
	               if(A.charAt(i-1) == '('){
	                   dp[i] = 2;
	                   if(i>=2)
	                   dp[i] += dp[i-2];
	               }
	                   else {
	                       int x = dp[i-1];
	                       
	                       if(i-x-1>=0 && A.charAt(i-x-1) == '('){
	                           dp[i] += dp[i-1]+2;
	                           if(i>=dp[i])
	                           dp[i] += dp[i-dp[i]];
	                       }
	                       else{
	                           dp[i]  = 0;
	                       }
	                   
	               }
	           }
	           ans = Math.max(ans, dp[i]);
	       }
	       System.out.println(ans);
	}

}
