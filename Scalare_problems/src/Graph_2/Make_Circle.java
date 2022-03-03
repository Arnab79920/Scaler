package Graph_2;

import java.util.ArrayList;

public class Make_Circle {
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


