package DP3;

/*Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aab"
 B = "c*a*b"
Input 2:

 A = "acz"
 B = "a.a"


Example Output

Output 1:

 1
Output 2:

 0*/

public class Regular_Expression_2 {
	public static void main(String[] args) {
		    String A = "acz";
		    String B = "a.a";
		    int n = A.length();
	        int m = B.length();
	        boolean k =  mach(n, m , A.toCharArray(), B.toCharArray());
	        if(k){
	            System.out.println(1);
	        }
	        else {
	        	System.out.println(0);
	        }
	}
	
	static boolean mach(int n , int m , char[] A, char[] B){
	       
        boolean dp[][] = new boolean[n+1][m+1];
       
        dp[0][0] = true;
        for(int j = 1; j<=m ; j++){
             if(B[j-1] == '*'){
                 dp[0][j] = dp[0][j-2];
             }
        }

        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=m ;j++){
                if(B[j-1] == '*'){
                 dp[i][j] = dp[i][j-2];
                 
                 if(A[i-1] == B[j-2] ||B[j-2] == '.' ){ 
                     dp[i][j] = dp[i][j-2] || dp[i-1][j];
                     }
                 
                }
                else if(B[j-1] == '.' || A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        
        
        
        return dp[n][m];
    }

}
