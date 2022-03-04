package Graph_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Problem Description

There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints

1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A



Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.



Output Format

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Example Input

Input 1:

 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:

 A = 2
 B = [1, 2]
 C = [2, 1]


Example Output

Output 1:

 1
Output 2:

 0*/


public class Possibility_of_Finishing {
	static ArrayList<ArrayList<Integer>> adj;	
	public static void main(String[] args) {
		int A = 2;
		int [] B = {1,2};
		int[] C = {2,1};
		adj = new ArrayList<>();
		PriorityQueue<Integer> pr = new PriorityQueue<>();
		
		for(int i = 0; i<A; i++) {
			adj.add(new ArrayList<>());
		}
		int[] freq = new int[A];
		for(int i = 0; i<B.length; i++) {
			adj.get(B[i]-1).add(C[i]-1);
		}
		
		for(int i = 0; i<A; i++) {
			for(int n : adj.get(i)) {
				freq[n]++;
			}
		}
		for(int i = 0; i<A; i++) {
			if(freq[i] == 0) {
				pr.add(i);
			}
		}
		ArrayList<Integer> ar = new ArrayList<>();
		while(!pr.isEmpty()) {
			int n = pr.poll();
			 ar.add(n);
			 for(int i : adj.get(n)) {
				 freq[i]--;
				 if(freq[i] == 0) {
					 pr.add(i);
				 }
			 }
			
		}
		if(ar.size()!=A) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}
	}

	}


