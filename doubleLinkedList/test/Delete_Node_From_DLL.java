package org.q10viking.doubleLinkedList.test;
import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data = data;
		next = prev = null;
	}
}

public class Delete_Node_From_DLL {

	Node head;
	
	void addToTheLast(Node node) {
		if(head == null) {
			head = node;
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
			node.prev = temp;
		}
	}
	
	void printList(Node head) {
		Node temp = head;
		System.out.println();
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			for(int i=0;i<n;i++) {
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			int deleteLocation = sc.nextInt();
			GFG g = new GFG();
			Node ptr = g.deleteNode(list.head,deleteLocation);
			list.printList(ptr);
			t--;
		}
	}
}

class GFG{
	public Node deleteNode(Node head,int x) {
		if(x<0)
			return null;
		Node deleteNode=head;
		while(deleteNode != null && x>1) {
			deleteNode = deleteNode.next;
			x--;
		}
		if(deleteNode != null) {
			if(head == deleteNode) {
				head = deleteNode.next;
			}
			
			if(deleteNode.next != null) {
				deleteNode.next.prev = deleteNode.prev;
			}
			
			if(deleteNode.prev != null) {
				deleteNode.prev.next = deleteNode.next;
			}
			
			return head;
		}else {
			return null;
		}
		
	}
	
}



/*2
4
1 6 3 9
2
5
1 4 5 9 2
1
1 3 9 
4 5 9 2*/

