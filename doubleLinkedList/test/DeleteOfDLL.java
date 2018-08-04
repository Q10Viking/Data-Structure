package org.q10viking.doubleLinkedList.test;
import org.q10viking.doubleLinkedList.DLL;
/*	delete nodes from the doubly linked list*/

public class DeleteOfDLL {

	public static void main(String[] args) {
		DLL dl = new DLL();
		
		dl.push(2);
		dl.push(4);
		dl.push(8);
		dl.push(10);
		
		System.out.println("Original Linked list:");
		dl.printList(dl.getHead());
		System.out.println();
		dl.deleteNode(dl.getHead(), dl.getHead());
		dl.printList(dl.getHead());
		
		System.out.println();
		
		dl.deleteNode(dl.getHead(), dl.getNextNode());
		dl.printList(dl.getHead());
		
		System.out.println();
		dl.deleteNode(dl.getHead(), dl.getNextNode());
		dl.printList(dl.getHead());
		
		
	}

}
