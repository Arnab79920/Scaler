package Searching_1;

/*Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of matrix A.



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ] 
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5 
Output 2:

 17


Example Explanation
Explanation 1:

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5. 
Explanation 2:

Median is 17.*/

public class Matrix_Median {
	public static void main(String[] args) {
		int[][] A = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
		 int k = search(A, A.length, A[0].length);
	      System.out.println(k);
	}
	

    static int search(int[][]A , int n , int m) {
		int low = Integer.MAX_VALUE;
	    int high = Integer.MIN_VALUE;
	      for(int i = 0; i<n; i++) {
	    	low = Math.min(low, A[i][0]);
	    	high = Math.max(high, A[i][m-1]);
	    }
	    
	   
		while(low<=high ) {
			int mid = (low+high)/2;
			int count = 0;
			for(int i = 0; i<n; i++) {
				count+=binarySearch(A[i], mid);
			}
			if(count<=((n*m)/2))low = mid+1;
			else high = mid-1;
		}
		return low;
			
	}
	
	static int binarySearch(int[]A , int elem) {
		int l = 0;
		int h = A.length-1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(A[mid]<=elem) {
				l = mid+1;
			}
			else {
				h = mid-1;
			}
		}
		return l;
	}

}
