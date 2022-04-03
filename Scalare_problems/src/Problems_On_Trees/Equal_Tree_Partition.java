package Problems_On_Trees;

import java.util.HashSet;
import java.util.Set;

/*Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
	TreeNode(){
		
	}
}

public class Equal_Tree_Partition {

	 static  Set<Long> set;
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        if(solve(root) == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
	}
	
	static public int solve(TreeNode A) {
	      set = new HashSet<Long>();
	      long totalSum = A.val+ DFS(A.left)+ DFS(A.right);
	      if(totalSum %2 !=0){
	          return 0;
	      }
	      if(totalSum % 2 == 0 && set.contains(totalSum/2)){
	          return 1;
	      } 
	      return 0;
	    
	    }
	    static long DFS(TreeNode A){
	        if(A == null)
	        return 0;
	        long sum = A.val+ DFS(A.left)+ DFS(A.right);
	        set.add(sum);
	        return sum;

	    }
}
