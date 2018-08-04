package org.q10viking.doubleLinkedList;

public class ReverseDoublyLinkedList extends DLL{

	void reverse() {
		Node temp = null;
		Node current = head;
		
		/*swap next and prev for all nodes of 
		doubly linked list*/
		while(current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		/*before changing head,check for the case like empty 
		list and list with only one node*/
		if(temp != null) {
			head = temp.prev;
		}
		
	}
	
	public static void main(String[] args) {
		ReverseDoublyLinkedList list = new ReverseDoublyLinkedList();
		
	/*	let us create a sorted linked list to test the functions
		created linked list will be 10->8->4->2 */
		list.push(2);
		list.push(4);
		list.push(8);
		list.push(10);
		
		System.out.println("Origianl linked list");
		list.printList(list.head);
		
		list.reverse();
		System.out.println();
		System.out.println("The reversed Linked List is ");
		list.printList(list.head);
		
	}

}

/*
Origianl linked list
Traversal in forward Direction
10->8->4->2->null
Traversal in reverse direction
2->4->8->10->null

The reversed Linked List is 
Traversal in forward Direction
2->4->8->10->null
Traversal in reverse direction
10->8->4->2->null
*/

