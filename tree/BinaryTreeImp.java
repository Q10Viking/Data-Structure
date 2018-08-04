package org.q10viking.tree;

/*Class containing left and right child of current node and key value
*/
class Node{
	int key;
	Node left,right;
	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}


public class BinaryTreeImp {
	//root of binary tree
	Node root;
	//Constructors
	public BinaryTreeImp(int key){
		root = new Node(key);
	}
	public BinaryTreeImp() {
		root = null;
	}
	
	public static void main(String[] args) {
		BinaryTreeImp tree = new BinaryTreeImp();
		//create root
		
		tree.root = new Node(1);
		/* following is the tree after above statement
		 
        1
      /   \
    null  null     */
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		  /* 2 and 3 become left and right children of 1
        1
      /   \
     2      3
   /    \    /  \
 null null null null  */
		
		
		tree.root.left.left = new Node(4);
	       /* 4 becomes left child of 2
			        1
			    /       \
			   2          3
			 /   \       /  \
			4    null  null  null
			/   \
			null null
			*/
		
	}

}
