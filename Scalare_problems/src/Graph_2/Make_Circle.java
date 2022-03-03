package Graph_2;

import java.util.ArrayList;

/*Problem Description

Given an array of strings A of size N, find if the given strings can be chained to form a circle.

A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

NOTE: All strings consist of lower case characters.



Problem Constraints

1 <= N <= 105

Sum of length of all strings <= 106



Input Format

First and only argument is a string array A of size N.



Output Format

Return an integer 1 if it is possible to chain the strings to form a circle else return 0.



Example Input

Input 1:

 A = ["aab", "bac", "aaa", "cda"]
Input 2:

 A = ["abc", "cbc"]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 We can chain the strings aab -> bac -> cda -> aaa -> aab. So this forms a circle. So, output will be 1. 
Explanation 2:

 There is no way to chain the given strings such that they forms a circle.
*/public class Make_Circle {
	public static void main(String[] args) {
		String[] A = {"aab", "bac", "aaa", "cda"};
		int n = A.length;
		boolean k = possibleAmongString(A, n);
		
		System.out.println(k);
		
	
	
}
static boolean possibleAmongString(String[] A, int n) {
	int m = 26;
	int in[] = new int[26];
	int out[] = new int[26];
	boolean[] mark = new boolean[26];
	
	
	ArrayList<
    ArrayList<Integer>> adj = new ArrayList<
                                  ArrayList<Integer>>();
	for(int i = 0; i < m; i++)
        adj.add(new ArrayList<>());
	for(int i = 0; i<A.length ; i++) {
		 int f = (int)(A[i].charAt(0) - 'a');
	        int l = (int)(A[i].charAt(
	                 A[i].length() - 1) - 'a');
	        mark[f] = mark[l] = true;
	          
	        // Increase indegree and outdegree count
	        in[l]++;
	        out[f]++;
	          
	        // Add an edge in graph
	        adj.get(f).add(l);
	}
	
	for(int i = 0; i<m ;i++) {
		if(in[i] != out[i])
			return false;
	}
	return isConnected(A[0].charAt(0)- 'a', mark, adj);
}

 static boolean  isConnected(int src, boolean[] mark, ArrayList<ArrayList<Integer>> adj) {
	 boolean[] visisted = new boolean[26];
	 DFS(visisted, src, adj);
	 for(int i = 0; i<26 ; i++) {
		 if(mark[i] && !visisted[i])
			 return false;
	 }
	 return true;
 }
 
 static void DFS(boolean[] visisted, int src, ArrayList<ArrayList<Integer>> adj) {
	 visisted[src] = true;
	 
	 for(int i : adj.get(src)) {
		 if(!visisted[i]) {
			 DFS(visisted, i, adj);
		 }
	 }
 }
}


