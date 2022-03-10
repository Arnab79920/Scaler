package DP4;

import java.util.ArrayList;
import java.util.Stack;


/*Problem Description

Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing all ones and return its area.



Problem Constraints

1 <= N, M <= 100



Input Format

First argument is an 2-D binary array A.



Output Format

Return an integer denoting the area of largest rectangle containing all ones.



Example Input

Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 


Example Output

Output 1:

 4
Output 2:

 3


Example Explanation

Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1,0), (1,1) and (1,2).*/

public class Max_Rectangle_in_Binary_Matrix {
	public static void main(String[] args) {
		int[][] A = { {1, 1, 1}, {0, 1, 1}, {1, 0, 0}};
		ArrayList<Integer> ar = new ArrayList<>();
		for(int j = 0; j<A[0].length; j++) {
			ar.add(A[0][j]);
			
			
		}
		int ans = largestArea(A[0]);
		
		for(int i = 1; i<A.length; i++) {
			for(int j = 0; j<A[0].length; j++) {
				if(A[i][j] == 0) {
					A[i][j] = 0;
				}
				else {
					A[i][j] = A[i][j]+A[i-1][j];
				}
			}
			
		  ans = Math.max(ans, largestArea(A[i]));
			
		}
		 System.out.println(ans);
		
	}
	
	
	
	

static int largestArea(int[] ar) {
	int n = ar.length;
	int l [] = nextSmallerL(ar);
	int r[] = nextSmallerR(ar);
	int area = Integer.MIN_VALUE;
	for(int i= 0; i<ar.length; i++) {
		int h = ar[i];
		int b = r[i]-l[i]-1;
		int new_area = h*b;
		area = Math.max(area, new_area);
	}
	return area;
}

static int[] nextSmallerL(int[] ar) {
	Stack<Integer> st = new Stack<>();
	int res[] = new int [ar.length];
	//int count  = 0;
	
	for(int i  = 0; i<ar.length; i++) {
		if(st.size() == 0) {
			res[0] = -1;
		}
		else {
			while(!st.isEmpty() && ar[i]<= ar[st.peek()]) {
				st.pop();
			}
			if(st.isEmpty()) 
				res[i] = -1;
			else 
				res[i] = st.peek();
			
			
		}
		st.push(i);
		
	}
	return res;
	
	
}

static int[]	nextSmallerR(int[] ar) {
	Stack<Integer> st = new Stack<>();
	int res[] = new int [ar.length];
	//int count  = 0;
	
	for(int i  = ar.length-1; i>=0; i--) {
		if(st.size() == 0) {
			res[ar.length-1] = ar.length;
		}
		else {
			while(!st.isEmpty() && ar[i]<= ar[st.peek()]) {
				st.pop();
			}
			if(st.isEmpty()) 
				res[i] = ar.length;
			else 
				res[i] = st.peek();
			
			
		}
		st.push(i);
		
	}
	return res;
	
	
}
	

}
