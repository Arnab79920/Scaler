package Backtracking2;

/*Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input

Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output

Output 1:

2
Output 2:

0


Example Explanation

Explanation 1:

We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

Answer is evident here.*/

public class Unique_Paths_III {
	 static int rowNumber[] = {-1, 1, 0, 0};
	 static int colNumber [] = {0, 0, 1, -1};
	 static int ans = 0;
	 public static void main(String[] args) {
			int[][] A = {{0,1}, {2,0}};
			int n = A.length;
			int m = A[0].length;
			int zero_count = 0;
			int start = 0;
			int end = 0;
			ans = 0;
			
			for(int i = 0; i<A.length; i++) {
				for(int j = 0; j<A[0].length; j++) {
					if(A[i][j] == 0) {
						zero_count++;
					}
					else if(A[i][j] == 1) {
						start = i;
						end = j;
					}
				}
			
		}
		boolean visisted[][] = new boolean[n][m];	
			
		uniquePath(A,visisted, zero_count, start, end, 0);	
		System.out.println(ans);
			
			
			
	}
		static void uniquePath(int[][] A, boolean[][] visited, int zero_count, int r, int c, int z) {
			visited[r][c] = true;
			if(A[r][c]== 0) {
				z++;
			}
			if(A[r][c] == 2) {
				if(zero_count == z) {
					ans++;
				}
				visited[r][c] = false;
				return;
			}
			
			for(int i = 0; i<4; i++) {
				int row = r+ rowNumber[i];
				int col = c + colNumber[i];
				if(isValid(A, visited, row, col))
					uniquePath(A, visited, zero_count, row, col, z);
					
			}
			visited[r][c] = false;
		}
		
		static boolean isValid(int[][]A, boolean[][]visited, int i , int j){
			if(i>=0 && j>=0 && i<A.length && j<A[0].length && A[i][j] !=-1 && !visited[i][j] ) {
				return true;
			}
			return false;
		}

}
