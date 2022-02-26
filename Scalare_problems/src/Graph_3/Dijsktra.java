package Graph_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].

The third argument given is an integer C.



Output Format

Return the integer array D.



Example Input

Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6] 
        [1, 2, 1] 
        [2, 5, 1] 
        [2, 4, 5] 
        [0, 3, 7] 
        [0, 1, 1] 
        [4, 5, 7] 
        [0, 5, 1] ] 
C = 4
Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4
*/

class Node implements Comparator<Node>{
	private int v;
	private int weight;
	Node(int v, int weight){
		this.v = v;
		this.weight = weight;
	}
	Node() {}
	int getV() { return v; }
    int getWeight() { return weight; }
	@Override
	public int compare(Node o1, Node o2) {
		if(o1.weight<o2.weight) {
			return -1;
		}
		if(o1.weight>o2.weight) {
			return 1;
		}
		return 0;
	}
	
	
}
public class Dijsktra {
static ArrayList<ArrayList<Node>> adj;
	
	public static void main(String[] args) {
		int [][]B= {{0, 4, 9},{3, 4, 6},{1, 2, 1}, {2, 5, 1}, {2, 4, 5}, 
				{0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}};
		int A = 6;
		int C = 4;
		adj = new ArrayList();
		for(int i = 0; i<=A; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i<B.length; i++) {
			adj.get(B[i][0]).add(new Node(B[i][1], B[i][2]));
			adj.get(B[i][1]).add(new Node(B[i][0], B[i][2]));
		}
		int[] a = shortestPath(adj, A, C);
        int k [] = new int [a.length];
        int idx = 0;
        for(int p : a){
         if(p == Integer.MAX_VALUE)   
           k[idx++] = -1;
        
        else{
             k[idx++] = p;
        }
        }
        
        for(int aa : k) {
        	System.out.println(aa);
        }
		 
		}
	   static int[] shortestPath(ArrayList<ArrayList<Node>> adj, int A , int C) {
		   int[]  dist = new int[A];
		   Arrays.fill(dist, Integer.MAX_VALUE);
		   dist[C] = 0;
		   PriorityQueue<Node> pq  = new PriorityQueue<>(A, new Node());
		   pq.add(new Node(C,0));
		   while(!pq.isEmpty()) {
			   Node node = pq.poll();
			   for(Node it : adj.get(node.getV())) {
				   if(dist[node.getV()] + it.getWeight()< dist[it.getV()]) {
					   dist[it.getV()] = dist[node.getV()] + it.getWeight();
					   pq.add(new Node(it.getV(), dist[it.getV()]));
				   }
			   }
		   }
		  
		   return dist;
	   }

}
