package org.q10viking.tree;

class QNode{
	int key;
	QNode left,right;
	QNode(int key){
		this.key = key;
		this.left = this.right = null;
	}
}

public class BinaryTreeTraversal_DFS {

	static void Inorder(QNode node) {
		if(node == null)
			return;
		Inorder(node.left);
		System.out.print(node.key+" ");
		Inorder(node.right);
	}
	
	static void Preorder(QNode node) {
		if(node == null)
			return;
		System.out.print(node.key+" ");
		Preorder(node.left);
		Preorder(node.right);
	}
	
	static void Postorder(QNode node) {
		if(node == null)
			return;
		Postorder(node.left);
		Postorder(node.right);
		System.out.print(node.key+" ");
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
		QNode root = new QNode(1);
		root.left = new QNode(2);
		root.left.left = new QNode(4);
		root.left.right = new QNode(5);
		root.right = new QNode(3);
		
		System.out.println("Inorder中序遍历：");
		Inorder(root);
		System.out.println("\nPreorder先序遍历：");
		Preorder(root);
		System.out.println("\nPostorder后序遍历：");
		Postorder(root);

	}

}

/*
Inorder中序遍历：
4 2 5 1 3 
Preorder先序遍历：
1 2 4 5 3 
Postorder后序遍历：
4 5 2 3 1 
*/
