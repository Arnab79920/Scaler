package Lowest_Common_Ancestor;


/*Problem Description
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105



Input Format
The first argument is a root node of the first tree, A.

The second argument is a root node of the second tree, B.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Values of the left child of the root node of the trees are different.*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
	TreeNode(){
		
	}
}
public class Identical_Binary_Trees {
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
        
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);
        root1.right.right.right = new TreeNode(9);
        boolean k = checkSame(root, root1);
        if(k)
       System.out.println(1);
        else
        System.out.println(0);
		
	}
	
	 static boolean checkSame(TreeNode A, TreeNode B){
	        if(A == null && B == null){
	            return true;
	        }
	        if( (A == null && B !=null) || (A != null && B ==null)){
	         return false;
	        }
	        if(A.val == B. val &&  checkSame(A.left, B.left) && checkSame(A.right, B.right) ){
	         return true;
	        }
	        return false;
	    }

}
