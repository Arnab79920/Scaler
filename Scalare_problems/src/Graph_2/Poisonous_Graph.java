package Graph_2;

import java.util.ArrayList;

/*You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.

You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.

Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.

NOTE:

Note that you have to write exactly one number on each vertex.
The graph does not have any self-loops or multiple edges.
Nodes are labelled from 1 to A.


Problem Constraints

1 <= A <= 3*105

0 <= M <= 3*105

1 <= B[i][0], B[i][1] <= A

B[i][0] != B[i][1]



Input Format

First argument is an integer A denoting the number of nodes.

Second argument is an 2D Matrix B of size M x 2 denoting the M edges.



Output Format

Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on the vertices of given graph so it becomes Poisonous . Since answer may be large, print it modulo 998244353.



Example Input

Input 1:

 A = 2
 B = [  [1, 2]
     ]
Input 2:

 A = 4
 B = [  [1, 2]
        [1, 3]
        [1, 4]
        [2, 3]
        [2, 4]
        [3, 4]
    ]


Example Output

Output 1:

 4
Output 2:

 0


Example Explanation

Explanation 1:

 There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
    [1, 2] , [3, 2], [2, 1] or [2, 3] repsectively.
Explanation 2:

 There is no way to make the graph poisonous.*/


public class Poisonous_Graph {
	static ArrayList<ArrayList<Integer>> adj;
    static int m = 998244353;
    static int a  = 0 ;
    static int b  = 0;
    public static void main(String[] args) {
    	int A = 2;
    	int B[][] = {{1, 2}};
    	 adj = new ArrayList<>();
 		for(int i = 0;i<=A; i++) {
 			adj.add(new ArrayList());
 		}
 		
 		for(int i = 0; i<B.length; i++) {
 			adj.get(B[i][0]-1).add(B[i][1]-1);
 			adj.get(B[i][1]-1).add(B[i][0]-1);
 		}
 		boolean[] visited = new boolean[A];
 		int color[]  = new int[A];
 		//Arrays.fill(color, -1);
         long[] dp = new long[A+1];
         dp[0] = 1;
         for(int i = 1; i<=A; i++){
          dp[i] = (dp[i-1]*2)%m;
         }
         long val  = 1;
 		for(int i = 0; i<A; i++) {
 			if(!visited[i]) {
                 a = 0;
                 b = 0;
 				boolean result = DFS(i,adj, visited, color, 0);
               // System.out.println(a);
                //System.out.println(b);
                 if(result == false) {
                	 System.out.println(0);
                 return ;
                 }
                 else{

                     val *= (dp[a]+dp[b])%m;
                     val = val%m;
                 }
                 
 			}
 		}
 		
 		System.out.println(val);
	}
    
    static boolean  DFS(int u,ArrayList<ArrayList<Integer>> adj, boolean[] visisted, int[] color, int clr) {
		visisted[u] = true;
		color[u] = clr;
		if(clr == 1){
            a++;
        }
        else{
            b++;
        }
		for(int n : adj.get(u)) {
			if(visisted[n]) {
				if(color[u] == color[n])
					return false;
			}
			else {
				if(!DFS(n, adj, visisted, color,1-color[u]))
					return false;
			}
		}
		return true;
	}

}
