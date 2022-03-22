package Graph_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



/*There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.



Example Input

Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output

Output 1:

 6
Output 2:

 6


Example Explanation

Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.*/

class  New_Node implements Comparator<New_Node>{
	int v;
	int av ;
	int weight;
	public New_Node(int v, int av , int weight) {
		this.v = v;
		this.weight = weight;
		this.av= av;
		
	}
	New_Node(){
		
	}
	
	public int compare(New_Node o1, New_Node o2) {
		if(o1.weight<o2.weight) {
			return -1;
		}
		 if(o1.weight>o2.weight) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
class Edge{
	int src;
	int nbr ;
	int weight;
	public Edge(int src, int nbr , int weight) {
		this.src = src;
		this.weight = weight;
		this.nbr= nbr;
		
	}
	Edge() {}
}
public class Commutable_Islands {
	static ArrayList<ArrayList<Edge>> adj;
	static int sum;
	public static void main(String[] args) {
		int A = 3;
		int B[][] = {{1, 2, 10}, {2, 3, 5}, {1, 3, 9}};
		  adj = new ArrayList();
			for(int i = 0;i<A; i++) {
				adj.add(new ArrayList<>());
			}
			int sum = 0;
			for(int i  = 0; i<B.length; i++) {
				adj.get(B[i][0]-1).add(new Edge(B[i][0]-1,B[i][1]-1, B[i][2]));
				adj.get(B[i][1]-1).add(new Edge(B[i][1]-1,B[i][0]-1, B[i][2]));
			}
			boolean visited[] = new boolean[A];
			PriorityQueue<New_Node> pq = new PriorityQueue<>(A, new New_Node());
			pq.add(new New_Node(0,-1,0));
			while(pq.size()>0) {
				New_Node rem = pq.remove();
				if(visited[rem.v] == true) {
					continue;
				}
				visited[rem.v] = true;
				if(rem.v !=-1) {
					sum += rem.weight;
					//System.out.println(rem.weight);
				}
				
				for(Edge e : adj.get(rem.v)) {
					if(!visited[e.nbr]) {
						pq.add(new New_Node(e.nbr,rem.v, e.weight));
					}
				}
			}
		System.out.println(sum);

}
}
