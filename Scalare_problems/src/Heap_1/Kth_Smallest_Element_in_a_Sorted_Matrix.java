package Heap_1;

/*Problem Description

Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A are sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.



Problem Constraints

1 <= N, M <= 500

1 <= A[i] <= 109

1 <= B <= N * M



Input Format

The first argument given is the integer matrix A.
The second argument given is an integer B.



Output Format

Return the B-th smallest element in the matrix.



Example Input

Input 1:

 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:

 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12


Example Output

Output 1:

 17
Output 2:

 16


Example Explanation

Explanation 1:

 6th smallest element in the sorted matrix is 17.
Explanation 2:

 12th smallest element in the sorted matrix is 16.


See Expected Output*/


public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	public static void main(String[] args) {
		int[][] A = {{5, 9, 11}, {9, 11, 13}, {10, 12, 15}, {13, 14, 16}, {16, 20, 21}};
		int B = 12;
		int n = A.length;
	    int m = A[0].length;
	    int k = search(A, n, m, B);
        System.out.println(k);
		
	}
	static int search(int[][] A, int n , int m , int B) {
		int low = A[0][0];
		int heigh = A[n-1][m-1];
		//System.out.println(heigh);
		
		while(low<=heigh) {
			int mid = (low+heigh)/2;
			int count = 0;
			for(int i = 0; i<n ; i++ ) {
				count += countFreq(A[i], mid);
			}
			if(count<B)low = mid+1;
			else heigh = mid-1;
		}
		return low;
	}

	static int countFreq(int[] A, int elem) {
		int low = 0;
		int heigh = A.length-1;
		while(low<=heigh) {
			int mid = (low + heigh)/2;
			if(A[mid]<=elem) {
				low = mid+1;
			}
			else {
				heigh = mid-1;
			}
			
		}
		return low;
	}

}
