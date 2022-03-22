package Graph_4;

import java.util.ArrayList;
import java.util.Collections;

/*Problem Description

Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].

For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:

The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A

1 <= B[i][1] <= 103



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].



Output Format

Return an one-dimensional binary array of size M denoting answer for each edge.



Example Input

Input 1:

 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]


Example Output

Output 1:

 [1, 1, 0]


Example Explanation

Explanation 1:

 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0]*/
class  New_Node1 implements Comparable<New_Node1>{
	int v;
	int u ;
	int weight;
	int index ;
	public New_Node1(int v, int u , int weight, int index) {
		this.v = v;
		this.weight = weight;
		this.u= u;
		this.index = index;
		
	}
	New_Node1(){
		
	}
	
	
	@Override
	public int compareTo(New_Node1 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
}

public class Edge_in_MST {
	static ArrayList<New_Node1> adj;
	static int maxn = 300009;
	static int [] parent = new int[maxn];
	static int[] rank = new int[maxn];
	public static void main(String[] args) {
		int A = 3;
		int B[][] = {{1, 2, 2}, {1, 3, 2}, {2, 3, 3}};
		ini();
		int [] ans = new int[B.length];
		for(int i = 0; i<B.length; i++) {
			adj.add(new New_Node1(B[i][1], B[i][0],B[i][2], i));
		}
		 Collections.sort(adj);
		int i = 0;
		int m = B.length;
		while(i<B.length) {
			int j = i;
			
			while(j<m && adj.get(j).weight == adj.get(i).weight  ) {
				if(find(adj.get(j).u) != find(adj.get(j).v)) {
					ans[adj.get(j).index] = 1;
					
				}
				j++;
			}
			j = i;
			while (j < m && adj.get(j).weight == adj.get(i).weight) {
				
	            if (find(adj.get(j).u) != find(adj.get(j).v))
	            	union(adj.get(j).u, adj.get(j).v);
	            j++;
	        }
			i =j;
		}
		
		for(int a : ans) {
			System.out.println(a);
		}

	}
	static void ini() {
		 adj = new ArrayList<New_Node1>();
		for(int i = 0; i<maxn; i++) {
			parent[i] = i;
		}
	}
	static int find(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
		
	}
	static void union(int x , int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot)
			return ;
		if(rank[xRoot]<rank[yRoot]) {
			parent[xRoot] = yRoot;
		}
		else if(rank[xRoot]>rank[yRoot]) {
			parent[yRoot] = xRoot;
		}
		else {
			parent[yRoot] = xRoot;
			rank[xRoot] = rank[xRoot]+1;
		}
	}
		

}
