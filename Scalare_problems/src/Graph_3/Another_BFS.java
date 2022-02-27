package Graph_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



/*Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 105

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.



Output Format

Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.



Example Input

Input 1:

 
A = 6
B = [   [2, 5, 1]
        [1, 3, 1] 
        [0, 5, 2] 
        [0, 2, 2] 
        [1, 4, 1] 
        [0, 1, 1] ] 
C = 3
D = 2
Input 2:

A = 2
B = [   [0, 1, 1]
    ] 
C = 0
D = 1


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.
Explanation 2:

 Path will be 0-> 1.*/
class NodeData{
	int v ;
	int weight;
	
	public NodeData(int v , int weight) {
		this.v = v;
		this.weight = weight;
	}
	NodeData() {}
	int getV() { return v; }
    int getWeight() { return weight; }
	
}
public class Another_BFS {
	static ArrayList<ArrayList<NodeData>> adj;
	public static void main(String[] args) {
		int A = 6;
		int B[][] = {{2, 5, 1}, {1, 3, 1}, {0, 5, 2}, 
					{0, 2, 2} , {1, 4, 1}, {0, 1, 1}};
		int C = 3;
		int D = 2;
		adj = new ArrayList<>();
		for(int i = 0; i<= A+B.length; i++) {
			adj.add(new ArrayList<>());
			
			}
		int v = A;
		for(int i = 0; i<B.length; i++) {
			if(B[i][2] == 2) {
				adj.get(B[i][0]).add(new NodeData(v, 1));
				adj.get(v).add(new NodeData(B[i][0], 1));
				adj.get(v).add(new NodeData(B[i][1], 1));
				adj.get(B[i][1]).add(new NodeData(v, 1));
				v++;
				}
			else {
				adj.get(B[i][0]).add(new NodeData(B[i][1], B[i][2])); 
				adj.get(B[i][1]).add(new NodeData(B[i][0], B[i][2])); 
					}
				}
				boolean visisted[] = new boolean[A+B.length];
				int count  = 0;
				int k =  findShortestPath(adj, visisted, C, D, count);
				System.out.println(k);
			    
		}
			    static int findShortestPath(ArrayList<ArrayList<NodeData>> adj, boolean[]visisted, int src, int target, int count) {
			    	visisted[src] = true;
			    	Queue<NodeData> q = new LinkedList();
			    	///int count = 0;
			    	q.add(new NodeData(src, 0));
			    	while(!q.isEmpty()) {
			    		NodeData n = q.poll();
			    		if(target == n.v)
			    		return n.weight;
			    		for(NodeData i : adj.get(n.v)) {
			    			
			    			if(!visisted[i.v]) {
			    				//count +=i.weight;
			    				visisted[i.v]= true;

			    				q.add(new NodeData(i.v, n.weight+1));
			    			}
			    		}
			    	}
			    	return -1;
			    }
}
