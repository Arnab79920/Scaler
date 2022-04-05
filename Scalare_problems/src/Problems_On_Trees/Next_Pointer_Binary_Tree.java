package Problems_On_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Next_Pointer_Binary_Tree {
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
        
        connect(root);
	}
	
	 public static void connect(TreeNode root) {
	        if(root == null){
	            root.next = null;
	        }
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        //root.next = null;
	        while(!q.isEmpty()){
	            int size = q.size();
	            
	           //TreeLinkNode prev  = null;
	            for(int i = 0; i<size;i++){
	                
	            	TreeNode node = q.remove();
	                 if(i<size-1){
	                     node.next = q.peek();
	                 }
	                if(node.left !=null){
	                    q.add(node.left);
	                }
	                if(node.right !=null){
	                    q.add(node.right);
	                }
	                //prev = node;
	                
	            }
	            
	           // node.left.next = node.right;
	        }
	        
	    }

}
