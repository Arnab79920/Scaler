package Backtracking2;

import java.util.ArrayList;

/*Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints

1 <= A <= 10



Input Format

First argument is an integer n denoting the size of chessboard



Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input

Input 1:

A = 4
Input 2:

A = 1


Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation

Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:

import java.util.ArrayList;*/

public class NQueens {
	public static void main(String[] args) {
		// initialize the vector as 0.
		int A = 4;
		String chesss[][] = new String[A][A];
		
		for(int i =  0; i<A; i++) {
			for(int j = 0; j<A; j++) {
				chesss[i][j] = ".";
			}
		}
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Nqueen(chesss,result, 0 );
		System.out.println(result);
		System.out.println();
		
		
		
}	
	
	public static void Nqueen(String[][]chesss,ArrayList<ArrayList<String>> result, int row ) {
		if(row == chesss.length) {
			ArrayList<String> list = new ArrayList<>();
			for(int i = 0; i<chesss.length; i ++) {
				String path = "";
				for(int j = 0;j<chesss.length; j++) {
					path +=chesss[i][j];
				}
				list.add(path);
			}
			result.add(list);
			return;
		}
		
		for(int col = 0; col<chesss.length; col++) {
			if(isSafe(chesss, row, col)) {
			chesss[row][col] = "Q";
			Nqueen(chesss, result, row+1);
			chesss[row][col] = ".";
			}
			
		}
	}
	
	static boolean isSafe(String[][] chess, int row, int col) {
		for(int i = row-1, j =col; i>=0; i--) {
			if(chess[i][j] == "Q") {
				return false;
			}
		}
		
		for(int i = row-1, j= col-1; i>=0&& j>=0; i--, j--) {
			if(chess[i][j] == "Q") {
				return false;
			}
		}
		
		for(int i = row-1, j= col+1; i>=0&& j<chess.length; i--, j++) {
			if(chess[i][j] == "Q") {
				return false;
			}
		}
		return true;
	}
	
}
