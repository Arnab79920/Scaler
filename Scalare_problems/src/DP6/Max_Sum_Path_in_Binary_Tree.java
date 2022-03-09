package DP6;



/*Problem Description

Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints

1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



Input Format

The first and the only argument contains a pointer to the root of T, A.



Output Format

Return an integer representing the maximum sum path.



Example Input

Input 1:

  
    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50


Example Output

Output 1:

 6
Output 2:

 40


Example Explanation

Explanation 1:

     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:

     The path with maximum sum is: 20 -> 20*/

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
     
    // Constructor
    TreeNode(int data)
    {
        val = data;
        left = null;
        right = null;
    }
}
public class Max_Sum_Path_in_Binary_Tree {
	 static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        maxPathSum(root);
        System.out.println(max);
	}
	
	 static public int maxPathSum(TreeNode A) {
	        max(A);
	        return max;
	}
	static int max(TreeNode A){
	  if(A == null){
	      return 0;
	  }
	  int l = Math.max(0,max(A.left));
	  int r = Math.max(0,max(A.right));

	  max = Math.max(max, l+r+ A.val);
	  return  A.val + Math.max(l,r);
	  
	}

}
