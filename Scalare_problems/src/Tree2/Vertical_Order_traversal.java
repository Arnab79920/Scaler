package Tree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints

0 <= number of nodes <= 105



Input Format

First and only arument is a pointer to the root node of binary tree, A.



Output Format

Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input

Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output

Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:
 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation

Explanation 1:

 First row represent the verical line 1 and so on.*/

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
public class Vertical_Order_traversal {
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
	       // verticalOrderTraversal(root);
	        System.out.println(verticalOrderTraversal(root));
	}
	
	 public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
	       TreeMap<Integer, ArrayList<Integer> > tm = new TreeMap<>();
	       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	       Queue<Integer> dist = new LinkedList<>();
	       Queue<TreeNode> q_node = new LinkedList<>();
	       q_node.add(A);
	       dist.add(0);
	       while(!q_node.isEmpty()){
	           TreeNode current = q_node.remove();
	           int h = dist.remove().intValue();
	           ArrayList<Integer> temp = tm.getOrDefault(h, null);
	           if(temp == null){
	               temp = new ArrayList<>();
	           }
	           temp.add(current.val);
	           tm.put(h, temp);
	           if(current.left!= null){
	             q_node.add(current.left);
	             dist.add(h-1);
	           }
	            if(current.right!= null){
	             q_node.add(current.right);
	             dist.add(h+1);
	           }
	       }

	       for(int a : tm.keySet()){
	           result.add(tm.get(a));
	       }
	       return result;
	       
	 }
	
	

}
