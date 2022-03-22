package Heap_2;

import java.util.Collections;
import java.util.PriorityQueue;

/*Problem Description

Given an array of integers A denoting a stream of integers. New arrays of integer B and C are formed. Each time an integer is encountered in a stream, append it at the end of B and append median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements are N in B and N is odd then consider medain as B[N/2] ( B must be in sorted order).
If the number of elements are N in B and N is even then consider medain as B[N/2-1]. ( B must be in sorted order).


Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of first i elements.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation

Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 */

public class Running_Median {
	public static void main(String[] args) {
	int[] A = {5, 17, 100, 11};
	PriorityQueue<Integer>left = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> right = new PriorityQueue<>();
	int[] result = new int[A.length];
	
	for(int i = 0; i<A.length; i++) {
		if(right.size()>0 && A[i]>right.peek()) {
			right.add(A[i]);
		}
		else {
			left.add(A[i]);
		}
		if(left.size() - right.size() ==2) {
			right.add(left.remove());
		}
		else if(right.size()- left.size() ==2) {
			left.add(right.remove());
		}
		if(left.size()>= right.size()) {
			result[i] = left.peek();
		}
		else {
			result[i] = right.peek();
		}
		
	}
	
	for(int a : result) {
		System.out.println(a);
	}
	
}

}
