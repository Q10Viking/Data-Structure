package org.q10viking.tree;
import java.util.Queue;
import java.util.LinkedList;

//Iterative Queue base Java program to do level order traversal 
//of Binary Tree
class BNode{
	int data;
	BNode left,right;
	public BNode(int data) {
		this.left = this.right = null;
		this.data = data;
	}
}


public class BinaryTreeTraversal_BFS {
	BNode root;
	BinaryTreeTraversal_BFS(BNode root){
		this.root = root;
	}
	
	public void printLevelOrder() {
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BNode tmp = queue.poll();
			System.out.print(tmp.data+" ");
			if(tmp.left != null)
				queue.add(tmp.left);
			if(tmp.right != null)
				queue.add(tmp.right);
		}
	}
	
	public static void main(String[] args) {
		//create binary tree:
	    /*
		        	1
			    /       \
			   2          3
			 /   \       /  \
			4     5   null  null
		  /   \
		null null
		*/
		BNode root = new BNode(1);
		root.left = new BNode(2);
		root.left.left = new BNode(4);
		root.left.right = new BNode(5);
		root.right = new BNode(3);
		
		
		BinaryTreeTraversal_BFS tree = new BinaryTreeTraversal_BFS(root);
		System.out.println("Level order traversal of binary tree is - ");
		tree.printLevelOrder();
	}

}
/*
Level order traversal of binary tree is - 
1 2 3 4 5 
*/
