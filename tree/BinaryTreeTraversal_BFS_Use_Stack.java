package org.q10viking.tree;

import java.util.Stack;
class SNode{
	int data;
	SNode left,right;
	public SNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
public class BinaryTreeTraversal_BFS_Use_Stack {
	SNode root;
	BinaryTreeTraversal_BFS_Use_Stack(SNode root){
		this.root = root;
	}
	
	void Inorder() {
		Stack<SNode> stack = new Stack<SNode>();
		SNode current = this.root;
		while(current != null || stack.size()>0) {
			
			while(current != null) {
				/*place pointer to a tree SNode on the 
				 * stack before traversing the SNode's left 
				 */
				stack.push(current);
				current = current.left;
			}
			
			//current must be null at this point
			current = stack.pop();
			System.out.print(current.data+" ");
			current = current.right;
			
		
		}
		
	}
	
	public static void main(String[] args) {
		SNode root;
		root = new SNode(1);
        root.left = new SNode(2);
        root.right = new SNode(3);
        root.left.left = new SNode(4);
        root.left.right = new SNode(5);
        
        BinaryTreeTraversal_BFS_Use_Stack tree = new BinaryTreeTraversal_BFS_Use_Stack(root);
        tree.Inorder();
        
	}

}
/*
4 2 5 1 3 

*/
