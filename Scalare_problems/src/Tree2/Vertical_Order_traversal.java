package Tree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

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
