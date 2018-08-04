package org.q10viking.doubleLinkedList;

/*Double Linked List*/

/*
 * Class for Doubly Linked List
*/
public class DLL {
	Node head;
	class Node{
		int data;
		Node prev;
		Node next;
		
		/*Constructor to create a new node
		 * next and prev is by default initialized as null
		 * */
		Node(int d){data = d;}
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getNextNode() {
		return head.next;
	}
	//Adding a node at the front of the list
	public void push(int new_data) {
		/*allocate node
		put in the data*/
		Node new_node = new Node(new_data);
		
		/*
		 * Make next of new node as head and previous as null
		 */
		new_node.prev = null;
		new_node.next = head;
		
		/*
		 * change prev of head node to new node
		 */
		if(head != null)
			head.prev = new_node;
		/*
		 * move the head to point to the new node
		 */
		head = new_node;
	}
	
	//Add a note at the end of the list
	public void append(int new_data) {
		Node new_node = new Node(new_data);
		Node last;
		Node current = head;
		new_node.next = null;
		
		if(head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}
		
		/*Else traverse till the last node*/
		while(current.next != null) {
			current = current.next;
		}
		last = current;
		
		/*change the next of last node*/
		last.next = new_node;
		//make last node as previous of new node
		new_node.prev = last;
		
	}
	
	//Given a node as prev_node,insert a new node after the given node
	public void InsertAfter(Node prev_node,int new_data) {
		/*check if the given prev_node is NULL*/
		if(prev_node == null) {
			System.out.println("The given previous node cannot be NULL");
			return;
		}
		
		/*
		 * allocate node
		 * put in the data
		 */
		Node new_node = new Node(new_data);
		
		/*Make next of new node as next of prev node*/
		new_node.next = prev_node.next;
		
		/*Make the next of prev_node as new_node*/
		prev_node.next = new_node;
		
		/* Make prev_node as previous of new_node */
		new_node.prev = prev_node;
		
		/*change previous of new_node's next node*/		
		if(new_node.next != null) {
			new_node.next.prev = new_node;
		}
		
	}
	
	/*function to delete a node in a Double linked list,
	head_ref --> pointer to head node pointer,
	del --> pointer to node to be deleted.*/
	
	public void deleteNode(Node head_ref,Node del) {
		/*base case*/
		if(head == null || del == null)
			return;
		
		/*	if node to be deleted is head note*/
		if(del == head) {
			head = del.next;
		}
		
		if(del.next != null) {
			del.next.prev = del.prev;
		}
		
		if(del.prev != null) {
			del.prev.next = del.next;
		}
		return;
			
	}
	
	//This function prints contents of linked list starting from the given node
	public void printList(Node node) {
		Node last=null;
		Node current=node;
		System.out.println("Traversal in forward Direction");
		while(current != null) {
			System.out.print(current.data+"->");
			last = current;
			current = current.next;
		}
		
		System.out.println("null");

		System.out.println("Traversal in reverse direction");
		while(last != null && last != node.prev) {
			System.out.print(last.data+"->");
			last = last.prev;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		DLL dll = new DLL();
		// Insert 6. So linked list becomes 6->NULL
		dll.append(6);
		
		// Insert 7 at the beginning. So linked list becomes 7->6->NULL
		dll.push(7);
		
		// Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
		dll.push(1);
		
		// Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
		dll.append(4);
		
		// Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
		dll.InsertAfter(dll.head.next, 8);
		
		System.out.println("Created DLL is:");
		dll.printList(dll.head);
		
		dll.printList(dll.head.next);
	}
	
}
